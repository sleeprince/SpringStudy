package app.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<HashMap> getTable() {
		return sqlSession.selectList("sql.selectAll");
	}
	
	public List<HashMap> getTable(int no) {
		return sqlSession.selectList("sql.select", no);
		
	}	
	
}
