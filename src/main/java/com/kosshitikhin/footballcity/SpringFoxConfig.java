package com.kosshitikhin.footballcity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    private final String authReferenceName = "Should set Value with token from /auth/login in format: \"Bearer TOKEN\" (without quotes)";
    @Value("${jwt.validity-time.access-token}")
    private Long accessTokenValidityTime;
    @Value("${jwt.validity-time.refresh-token}")
    private Long refreshTokenValidityTime;
    @Value("${app.version}")
    private String appVersion;
    @Value("${app.name}")
    private String appName;

    @Bean
    public Docket actuatorApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(i -> RequestHandlerSelectors.basePackage("org.springframework.boot").negate().test(i))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .directModelSubstitute(Date.class, Long.class);
    }

    private SecurityReference defaultAuth() {
        return new SecurityReference(authReferenceName, new AuthorizationScope[0]);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(Collections.singletonList(defaultAuth()))
                .forPaths(PathSelectors.any()).build();
    }

    private ApiKey apiKey() {
        return new ApiKey(authReferenceName, "Authorization", "header");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(appName)
                .description(String.format("This is %s documentation.\n", appName) +
                        "All requests can be executed and tested right from this documentation. Use Authorise button on the right.\n" +
                        "Use as login/password your user with USER or ADMIN role.\n" +
                        "Should insert there accessToken from [authentication-controller]/auth/login in format: \"Bearer TOKEN\" (without quotes)\n" +
                        "Warning: access token has TTL and will expire in " + Duration.ofMillis(accessTokenValidityTime).toHours() + " hours\n" +
                        "You can use adminLogin##userLogin and admin password to mimic any user.\n" +
                        "There is no session on server, so there is no logout and server is stateless." +
                        "On login request you also receive refresh token to refresh your access token after its expiration. " +
                        "Send your refresh token to [authentication-controller]/auth/refresh-token to receive new tokens. " +
                        "Refresh token also has TTL and will expire in " + Duration.ofMillis(refreshTokenValidityTime).toDays() + " days. " +
                        "Tokens should be stored in secure place.")
                .version(appVersion)
                .build();
    }
}
