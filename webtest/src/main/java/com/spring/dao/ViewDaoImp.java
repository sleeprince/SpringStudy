package com.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ViewDaoImp implements ViewDao {
	
	private final SqlSession session;
	
}
