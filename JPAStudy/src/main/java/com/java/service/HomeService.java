package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.UserEntity;
import com.java.repository.UserEntityRepository;

@Service
public class HomeService {

	@Autowired
	private UserEntityRepository uer;
	
	public UserEntity findHer() {
		return uer.findByUserNm("최유미");
	}
	
	public UserEntity findMe() {
		return uer.findByUserNmAndUserPwd("노광수", "1234");
	}
	 
}
