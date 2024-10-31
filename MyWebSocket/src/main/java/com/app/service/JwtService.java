package com.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.TokenDTO;
import com.app.dto.UserDTO;
import com.app.mapper.Temp1Mapper;
import com.app.mapper.UserMapper;
import com.app.util.JwtToken;

@Service
public class JwtService {
	
	@Autowired
	private UserMapper um;
	
	@Autowired
	private Temp1Mapper tm;

	@Autowired
	private JwtToken jwtToken;

	public TokenDTO login(Map<String, String> params) {
		String userPwd = params.get("userPwd");
		boolean state = false;
		String jwt = null;
		
		UserDTO user = UserDTO.builder()
				.userNm(params.get("userNm"))
				.userPwd(params.get("userPwd"))
				.build();
		user = um.findUser(user).orElseThrow();
		if(user != null) {
			state = true;
			jwt = jwtToken.setToken(user);
		}
//		if(userPwd != null) {
//			UserDTO user = um.findUser(params.get("userNm")).orElseThrow();
//			//비밀번호 일치 여부 확인
//			if( passwordEncoder.matches(userPwd, user.getUserPwd()) ) { 
//				state = true;
//				jwt = jwtToken.setToken(user);
//			}
//		}		
		return TokenDTO.builder()
				.state(state)
				.token(jwt)
				.build();
	}
	
	public Map<String, Object> save(Map<String, Object> map) {
		if(jwtToken.isValidToken(map.get("token").toString()));
		map.put("userNo", jwtToken.getUser(map.get("token").toString()).getUserNo());
		tm.save(map);
		return map;
	}
	
}
