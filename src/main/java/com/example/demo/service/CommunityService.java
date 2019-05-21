package com.example.demo.service;

import java.util.Collection;

public interface CommunityService {

    domen.Community save(domen.Community person);

    Boolean delete(int id);

    domen.Community update(domen.Community person);

    domen.Community findById(int id);

    domen.Community findByName(String name);

    Collection<domen.Community> findAll();
}
