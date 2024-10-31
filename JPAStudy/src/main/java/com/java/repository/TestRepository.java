package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer>{
	
}
