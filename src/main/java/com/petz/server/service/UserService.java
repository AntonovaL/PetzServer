package com.petz.server.service;

import com.petz.server.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(int id);
    User save(User user);
    void delete(int id);
}
