package com.huhaoran.esproject.security;

import com.huhaoran.esproject.entity.UserEntity;
import com.huhaoran.esproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * 自定义认证实现
 */
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private IUserService userService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String inputPassword = authentication.getCredentials().toString();
        UserEntity userEntity = userService.findUserEntityByName(userName);
        if(userEntity == null){
            throw new AuthenticationCredentialsNotFoundException("authError");
        }
        if(inputPassword.equals(userEntity.getName())){//TODO MD5
            
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
