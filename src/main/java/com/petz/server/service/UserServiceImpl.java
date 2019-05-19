package com.petz.server.service;

import com.petz.server.entity.User;
import com.petz.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

}


