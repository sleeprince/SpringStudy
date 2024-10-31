package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
	
	public UserEntity findByUserNm(String userNm);
	public UserEntity findByUserNmAndUserPwd(String userNm, String userPwd);
}
