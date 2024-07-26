package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.TempDTO;

@Repository
public class ListDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<TempDTO> findAll(TempDTO dto){
		return sqlSession.selectList("sql.findAll", dto);
	}
	
	public TempDTO findOne(TempDTO dto) {
		return sqlSession.selectOne("sql.findOne", dto);
	}
	
	public int edit(TempDTO dto) {
		return sqlSession.update("sql.edit", dto);
	}
	
	public int accept(TempDTO dto) {
		return sqlSession.update("sql.accept", dto);
	}
	
	public TempDTO save(TempDTO dto) {
		sqlSession.insert("sql.save", dto);
		return dto;
	}
}
