package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    void save(User user);

    User findById(int id);

    void update(int id, User customer);

    void remote(int id);
}
