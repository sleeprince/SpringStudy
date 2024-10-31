package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.UserEntity;
import com.app.service.UserService;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home () {
		return "HOME";
	}
	
	@Autowired
	private UserService uService;
	
	@GetMapping("findByUserNm") 
	public List<UserEntity> findByUserNm() {
//		return uService.findByUserNm();
//		return uService.findByUserNmAndUserPwd();
//		return uService.findByUserNmLike();
//		return uService.findByUserNmStartingWith();
//		return uService.findByUserNmEndingWith();
		return uService.findByUserNmContaining();
	}
	
}
