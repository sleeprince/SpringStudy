package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.myDTO.MyDTO;

@Repository
public class ViewDao {
	@Autowired 
	private SqlSession sqlSession;
	
	public List<MyDTO> findAll(MyDTO dto){
		return sqlSession.selectList("sql.findAll", dto);
	}
	
	public MyDTO findOne(int no) {
		return sqlSession.selectOne("sql.findOne", no);
	}
	
	public int update(MyDTO dto) {
		return sqlSession.update("sql.update", dto);
	}
	
	public int accept(MyDTO dto) {
		return sqlSession.update("sql.accept", dto);
	}
	
	public MyDTO save(MyDTO dto) {
		sqlSession.insert("sql.save", dto);
		return dto;
	}
}
