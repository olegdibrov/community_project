package com.example.demo.config;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domen.User;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userName);
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(new SimpleGrantedAuthority(user.getRole().getName()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), true, true, true, true, grantedAuthority);

    }
}
