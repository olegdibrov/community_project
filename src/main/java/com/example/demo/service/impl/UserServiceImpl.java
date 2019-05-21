package com.example.demo.service.impl;

import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.PasswordEncryptor;
import domen.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = PasswordEncryptor.getInstance().passwordEncoder;

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.getOne(1));
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Collection<User> findAll() {
        Iterable<User> itr = userRepository.findAll();
        return (Collection<User>) itr;
    }
}
