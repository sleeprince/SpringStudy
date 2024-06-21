package app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<HashMap> getData(){		
		return sqlSession.selectList("sql.selectContent");
	}
	
	public List<HashMap> getDataApproval(int app){		
			return sqlSession.selectList("sql.selectApp", app);
	}
	
	public List<HashMap> getDataHana(int num){		
		return sqlSession.selectList("sql.selectOne", num);
	}
	
	public int getLastest(){		
		return sqlSession.selectOne("sql.getLastest");
	}
	
	public boolean insertOne(Map<String, Object> map) {
		if(sqlSession.insert("sql.insertOne", map) > 0)
			return true;
		return false;
	}
	
	public boolean updateOne(Map<String, Object> map) {
		if(sqlSession.update("sql.updateOne", map) > 0)
			return true;
		return false;
	}
	
	public boolean updateApp(Map<String, Object> map) {
		if(sqlSession.update("sql.updateApp", map) > 0)
			return true;
		return false;
	}
}
