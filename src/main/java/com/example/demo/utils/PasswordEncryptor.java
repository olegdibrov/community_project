package com.example.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncryptor {

    private static PasswordEncryptor passEncoding = new PasswordEncryptor();
    public BCryptPasswordEncoder passwordEncoder;

    public static PasswordEncryptor getInstance() {
        if (passEncoding != null)
            return passEncoding;
        return new PasswordEncryptor();
    }

    private PasswordEncryptor() {
        passwordEncoder = new BCryptPasswordEncoder();
    }
}
