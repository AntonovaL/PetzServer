package com.petz.server.repository;


import com.petz.server.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AnimalsRepository extends JpaRepository<Animal,Integer> {
    //@Query("SELECT a FROM animals a WHERE a.ownerid = ?1")
     List<Animal> findAllByOwnerId(int ownerid);
     List<Animal> findByTypeAndSex(String type, String sex);
      List<Animal> findByTypeAndSexAndAgeBetween(String type, String sex,float ageFrom, float ageTo);
      List<Animal> findByType(String type);
      List<Animal> findBySex(String sex);

}