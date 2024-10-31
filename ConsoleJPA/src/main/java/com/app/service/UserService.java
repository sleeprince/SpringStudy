package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.UserEntity;
import com.app.repository.UserEntityRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserEntityRepository userEntityRepository;
	
	public void run() {
		log.info("UserService Run!");
		log.info("user: {}", select(3));
	}
	
	private void insert() {
		UserEntity user = new UserEntity();
		user.setUserNm("노광수");
		user.setUserPwd("1234");
		userEntityRepository.save(user);
	}
	
	private UserEntity select(int no) {
		return userEntityRepository.findById(no).orElseThrow();
	}
	
	private void update(int no) {	
		UserEntity user = select(no);
		user.setUserNm("노굥");
		userEntityRepository.save(user);
	}
	
	private void delete(int no) {
//		UserEntity user = select(no);
//		userEntityRepository.delete(user);
		userEntityRepository.deleteById(no);
	}
	
}
