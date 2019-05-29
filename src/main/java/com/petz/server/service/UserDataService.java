package com.petz.server.service;

import com.petz.server.entity.User;
import com.petz.server.entity.UserData;

import java.util.List;

public interface UserDataService {
    UserData getById(int id);
    UserData save(UserData user);
    void delete(int id);
}
