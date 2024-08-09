package com.java.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mapper.DataMapper;

@Service
public class DataService {
	
	@Autowired
	private DataMapper mapper;
	
	public List<Map<String, Object>> findList(){
		return mapper.findList();
	}
	
	public String check(int noticeNum) {
		List<Integer> qualifiedUser = new ArrayList<>();
		qualifiedUser.add(5);
		qualifiedUser.add(6);
		qualifiedUser.add(11);
		int boardUser =	mapper.findUseNo(noticeNum);
		for(int user : qualifiedUser) {
			if(user == boardUser)
				return "글 번호 " + noticeNum + "에 접근할 수 있습니다.";
		}
		return "글 번호 " + noticeNum + "에 접근할 수 없습니다.";
	}
}
