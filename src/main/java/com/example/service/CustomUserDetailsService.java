package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.UserMapper;
import com.example.entity.UserInfo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws AuthenticationException {

        UserInfo loginUser = userMapper.getUserById(username);

        if(loginUser != null) {
            // Succ
        } else {
            // Fail
            throw new UsernameNotFoundException("99");
        }

        return loginUser;
    }
    
}
