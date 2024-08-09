package com.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapper {

	@Select("Select 1")
	public int tets();
	
	@Select("SELECT a.noticeNo as 'no', a.noticeTitle as 'title', a.noticeContent as 'content', b.userNm as 'user', b.userRole as 'role' "
			+ "FROM notice AS a "
			+ "INNER JOIN `user` AS b "
			+ "	ON a.userNo = b.userNO")
	public List<Map<String, Object>> findList();
	
	@Select("SELECT userNo From notice WHERE noticeNo = #{no}")
	public int findUseNo(int no);
}
