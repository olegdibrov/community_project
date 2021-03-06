package com.example.demo.service.impl;

import com.example.demo.domen.Role;
import com.example.demo.repository.CommunityRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Boolean delete(int id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).get();
    }



    @Override
    public Collection<Role> findAll() {
        Iterable<Role> itr = roleRepository.findAll();
        return (Collection<Role>) itr;
    }
}
