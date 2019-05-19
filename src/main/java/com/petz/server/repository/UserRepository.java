package com.petz.server.repository;

import com.petz.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
     Optional<User> findByUserName(String userName);
     Boolean existsByUserName(String userName);
}

