package com.petz.server.service;

import com.petz.server.entity.Animal;
import com.petz.server.repository.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalsRepository repository;

    @Override
    public Animal getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public Animal save(Animal animal) {
        return repository.save(animal);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Animal> getAllByOwnerId(int id){return repository.findAllByOwnerId(id);}

    @Override
    public List<Animal> getAllByTypeAndSex(String type, String sex){return repository.findByTypeAndSex(type,sex);}

    @Override
    public List<Animal> getAllByType(String type){return repository.findByType(type);}

    @Override
    public List<Animal> getAllBySex(String sex){return repository.findBySex(sex);}

    @Override
    public List<Animal> getAllByParams(String type, float ageFrom, float ageTo, String sex){
        return repository.findByTypeAndSexAndAgeBetween(type,sex,ageFrom,ageTo);
    }

    @Override
    public List<Animal> getAll(){return repository.findAll();}
}