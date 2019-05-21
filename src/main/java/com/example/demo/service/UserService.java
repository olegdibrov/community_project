
package com.example.demo.service;

import java.util.Collection;

public interface UserService {
    domen.User save(domen.User user);

    Boolean delete(int id);

    domen.User update(domen.User user);

    domen.User findById(int id);

    domen.User findByEmail(String email);

    Collection<domen.User> findAll();
}
