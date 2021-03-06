package com.example.demo.service.impl;

import com.example.demo.repository.CommunityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

import domen.Community;

@Service
public class CommunityServiceImpl implements CommunityService {


    @Autowired
    private CommunityRepository communityRepository;

    @Override
    public Community save(Community community) {
        return communityRepository.save(community);
    }

    @Override
    public Boolean delete(int id) {
        if (communityRepository.existsById(id)) {
            communityRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Community update(Community community) {
        return communityRepository.save(community);
    }

    @Override
    public Community findById(int id) {
        return communityRepository.findById(id).get();
    }


    @Override
    public Community findByName(String name) {
        return communityRepository.findByName(name);
    }

    @Override
    public Collection<Community> findAll() {
        Iterable<Community> itr = communityRepository.findAll();
        return (Collection<Community>) itr;
    }
}
