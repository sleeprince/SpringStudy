package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TokenDTO;
import com.app.dto.UserDTO;
import com.app.mapper.Temp1Mapper;
import com.app.mapper.UserMapper;
import com.app.service.JwtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequiredArgsConstructor
public class DataController {

	private final Temp1Mapper tm;
	
	//private final UserMapper um;
	
	private final SimpMessagingTemplate simpMessagingTemplate;
	
	private final JwtService jwtService;
	
	@PostMapping(value = {"/findList", "/findList/{accept:[0-1]}"})
	public List<Map> findList(@PathVariable(name = "accept", required = false) String accept) {
		log.info("Accept : {}", accept);
		return tm.findList(accept);
	}
	
	@PostMapping("/save")
	public Map<String, Object> save(@RequestParam Map<String, Object> map) {
		log.info("Map : {}", map);
//		tm.save(map);
		return jwtService.save(map);
	}
	
	@PostMapping("/detail/{no:[0-9]+}")
	public Map detail(@PathVariable(name = "no") int no) {
		log.info("No : {}", no);
		Map map = tm.findOne(no);
		log.info("Map : {}", map);
		if(map != null) {
			map.put("status", true);
		} else {
			map = new HashMap<>();
			map.put("status", false);
		}
		return map;
	}
	
	@PostMapping("/detail/{no:[0-9]+}/{accept:[0-1]}")
	public Map detail(@PathVariable(name = "no") int no, @PathVariable(name = "accept") String accept, Map map) {
		log.info("No : {}, Accept : {}", no, accept);
		map.put("status", false);
		if(accept != null) {
			map.put("no", no);
			map.put("accept", accept);
			if(tm.accept(map) == 1) {
				map = tm.findOne(no);
				map.put("status", true);
				
				simpMessagingTemplate.convertAndSend("/topic/accept", map);
			}
		}
		return map;
	}
	
	@PostMapping("/edit")
	public Map edit(@RequestParam Map map) {
		log.info("Map : {}", map);
		map.put("status", false);
		if(tm.edit(map) == 1) {
			map = tm.findOne(Integer.parseInt(map.get("no").toString())); 
			map.put("status", true);
		}
		return map; 
	}
	
	@PostMapping("/login")
	public TokenDTO login(@RequestParam Map<String, String> map) {
		log.info("USER : {}", map);
		
//		UserDTO user = UserDTO.builder()
//				.userNm(map.get("userNm").toString())
//				.userPwd(map.get("userPwd").toString())
//				.build();
//		user = um.findUser(user);
//		Map<String, Object> userData = new HashMap<>();
//		if(user != null) {
//			userData.put("userNo", user.getUserNo());
//			userData.put("userNm", user.getUserNm());
//			userData.put("userPwd", user.getUserPwd());
//			userData.put("status", 1);
//		}else {
//			userData.put("status", 0);
//		}
//		
//		return userData;
		return jwtService.login(map);
	}
	
}
