package com.petz.server.service;

import com.petz.server.entity.UserData;
import com.petz.server.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl implements UserDataService {
    @Autowired
    private UserDataRepository repository;
    @Override
    public UserData getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public UserData save(UserData user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
