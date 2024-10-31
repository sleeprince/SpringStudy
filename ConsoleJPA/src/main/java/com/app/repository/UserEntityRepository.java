package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {}
