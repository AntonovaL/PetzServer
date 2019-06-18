package com.petz.server.service;

import com.petz.server.entity.Animal;
import com.petz.server.entity.UserData;

import java.util.List;

public interface AnimalService {
    Animal getById(int id);
    List<Animal> getAllByOwnerId(int id);
    Animal save(Animal user);
    void delete(int id);
    List<Animal> getAllByTypeAndSex(String type, String sex);
    List<Animal> getAllByParams(String type, float ageFrom, float ageTo, String sex);
    List<Animal>  getAllByType(String type);
    List<Animal> getAllBySex(String sex);
    List<Animal> getAll();
}
