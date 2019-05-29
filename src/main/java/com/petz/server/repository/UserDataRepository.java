package com.petz.server.repository;

import com.petz.server.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDataRepository extends JpaRepository<UserData, Integer> {
}
