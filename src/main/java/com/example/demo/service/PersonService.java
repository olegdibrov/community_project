package com.example.demo.service;

import java.util.Collection;

public interface PersonService {
    domen.Person save(domen.Person person);

    Boolean delete(int id);

    domen.Person update(domen.Person person);

    domen.Person findById(int id);


    domen.Person findByEmail(String email);

    Collection<domen.Person> findAll();
}
