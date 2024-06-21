package com.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.TempDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ViewDaoImp implements ViewDao {
	
	private final SqlSession session;
	
	public TempDTO test(TempDTO dto) {
		return session.selectOne("sql.findOne", dto);
	}

}
