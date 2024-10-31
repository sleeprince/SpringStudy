package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JpaService {
	
	@Autowired
	private EntityManagerFactory eFactory;

	public void run() {
		log.info("JpaService Run!");
		EntityManager eManager = eFactory.createEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		
		try {
			eTransaction.begin();
			
//			insert(eManager);
			update(eManager);
			
			eTransaction.commit();
		}catch(Exception e){
			eTransaction.rollback();
		}finally {
			eManager.close();
		}
	}
	
	private void insert(EntityManager eManager) {
		UserEntity user = new UserEntity();
		user.setUserNm("최유미");
		user.setUserPwd("1234");
		
		eManager.persist(user);// 데이블에 데이터 적용하라
	}
	
	private UserEntity select(EntityManager eManager, int no) {
		return eManager.find(UserEntity.class, no);
	}
	
	private void update(EntityManager eManager) {
		UserEntity user = select(eManager, 2);
		user.setUserNm("최와와");
		log.info("user : {}", select(eManager, 2));
	}
	
	private void delete(EntityManager eManager) {
		UserEntity user = select(eManager, 2);
		eManager.remove(user);
	}
	
}
