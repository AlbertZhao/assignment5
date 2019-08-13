package com.zhaoshijie.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Demo class
 *
 * @author Albert
 * @date 2019/08/13
 */
@Component
public class LoginAuthticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        //only for demo, actually we need to retrieve from DB to verify
        if (!"password".equals(password)  || ! "username".equals(username)) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }

        //only for demo, we need to input the user roles
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), null, authentication.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
