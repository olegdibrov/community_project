package com.example.demo.service.impl;

import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import domen.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Boolean delete(int id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findById(int id) {
        return personRepository.findById(id).get();
    }


    @Override
    public Person findByEmail(String name) {
        return personRepository.findByEmail(name);
    }

    @Override
    public Collection<Person> findAll() {
        Iterable<Person> itr = personRepository.findAll();
        return (Collection<Person>) itr;
    }
}
