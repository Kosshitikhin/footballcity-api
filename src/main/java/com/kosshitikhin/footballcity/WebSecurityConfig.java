package com.kosshitikhin.footballcity;

import com.kosshitikhin.footballcity.auth.GeneralUserDetailsService;
import com.kosshitikhin.footballcity.auth.GeneralWebSecurityConfig;
import com.kosshitikhin.footballcity.auth.JWTAuthenticationEntryPoint;
import com.kosshitikhin.footballcity.auth.JWTRequestFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends GeneralWebSecurityConfig {
    private final JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JWTRequestFilter jwtRequestFilter;

    public WebSecurityConfig(GeneralUserDetailsService generalUserDetailsService, JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint, JWTRequestFilter jwtRequestFilter) {
        super(generalUserDetailsService);
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // We don't need CSRF for this example
                .csrf().disable()
                // don't authenticate this particular request
                .authorizeRequests()
                .antMatchers("/monitoring/**").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/*").permitAll()
                .anyRequest()
                .authenticated()
                .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

}