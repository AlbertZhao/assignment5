package com.zhaoshijie.config;

import com.zhaoshijie.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final static String USER_LOGIN_URL = "/assignment/security/login";
    private final static String USER_REGISTER_URL = "/assignment/users/register";

    @Autowired
    private RestAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    private LoginAuthticationProvider loginAuthticationProvider;

    @Autowired private LoginAuthenticationSuccessHandler successHandler;
    @Autowired private LoginAuthenticationFailureHandler failureHandler;

    protected LoginAuthenticationFilter buildLoginAuthenticationFilter(String defaultProcessUrl) {
        LoginAuthenticationFilter loginAuthenticationFilter = new LoginAuthenticationFilter(defaultProcessUrl, successHandler, failureHandler);
        loginAuthenticationFilter.setAuthenticationManager(authenticationManager);
        return loginAuthenticationFilter;
    }

    protected JwtAuthorizationTokenFilter buildJwtAuthorizationTokenFilter(List<String> pathsToSkip, String pattern) {
        SkipPathRequestMatcher requestMatcher = new SkipPathRequestMatcher(pathsToSkip, pattern);
        JwtAuthorizationTokenFilter jwtAuthorizationTokenFilter = new JwtAuthorizationTokenFilter(requestMatcher);
        jwtAuthorizationTokenFilter.setAuthenticationManager(authenticationManager);
        return jwtAuthorizationTokenFilter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<String> permitAllEndpointList = Arrays.asList(
                USER_LOGIN_URL,
                USER_REGISTER_URL,
                "/assignment/h2"
        );
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable().headers().frameOptions().sameOrigin()
                .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                    .authorizeRequests()
                    .antMatchers("/**")
                    .permitAll()
                .and()
                    .addFilterBefore(buildLoginAuthenticationFilter(USER_LOGIN_URL), UsernamePasswordAuthenticationFilter.class)
                    .addFilterBefore(buildJwtAuthorizationTokenFilter(permitAllEndpointList, "/assignment/**"), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(loginAuthticationProvider);
        auth.authenticationProvider(jwtAuthenticationProvider);
    }
}
