package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domen.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByEmail(String name);
}
