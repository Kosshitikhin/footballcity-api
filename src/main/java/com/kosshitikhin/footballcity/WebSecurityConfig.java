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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Order(2)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends GeneralWebSecurityConfig {
    private final JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JWTRequestFilter jwtRequestFilter;

    public WebSecurityConfig(GeneralUserDetailsService userDetailsService, JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint, JWTRequestFilter jwtRequestFilter, PasswordEncoder passwordEncoder) {
        super(userDetailsService, passwordEncoder);
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtRequestFilter = jwtRequestFilter;
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // We don't need CSRF for this example
                .csrf().disable()
                // dont authenticate this particular request
                .authorizeRequests()
                .antMatchers("monitoring/**").permitAll()
                .antMatchers(HttpMethod.POST, "auth/*").permitAll()
                // all other requests need to be authenticated
                .anyRequest().authenticated()
                // make sure we use stateless session; session won't be used to
                // store user's state.
                .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}