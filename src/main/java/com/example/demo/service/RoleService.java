package com.example.demo.service;

import com.example.demo.domen.Role;

import java.util.Collection;

public interface RoleService {
    Role save(Role role);

    Boolean delete(int id);

    Role update(Role role);

    Role findById(int id);

    Collection<Role> findAll();
}
