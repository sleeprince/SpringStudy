package com.example.BootTest.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class T1Dao {
	
	@Autowired @Qualifier("sql1")
	private SqlSession sql1;
	
	@Autowired @Qualifier("sql2")
	private SqlSession sql2;	
	
	public int test() {
		return sql1.selectOne("sql.test");
	}
	
	public List<Map> findAll(){
		return sql1.selectList("sql.findAll");
	}
	
	public int insert(Map map) {
		return sql2.insert("sql.save", map);
	}
	
	public void ok() {
		sql2.commit();
	}
	
	public void rollBack() {
		sql2.rollback();
	}
}
