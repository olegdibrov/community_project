package com.example.demo.service;

public interface SecurityService {

    String findLoggedInEmail();

    void autoLogin(String username, String password);
}
