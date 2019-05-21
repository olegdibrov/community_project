package com.example.demo.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import domen.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer> {
    Community findByName(String name);
}
