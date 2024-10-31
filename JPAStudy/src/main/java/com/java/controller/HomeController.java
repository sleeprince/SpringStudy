package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Test;
import com.java.model.UserEntity;
import com.java.repository.TestRepository;
import com.java.service.HomeService;

@RestController
public class HomeController {

	@Autowired
	private HomeService service;
	
//	@GetMapping("/test")
//	public List<Test> test() {
//		return testRes.findAll();
//	}
//	
	@GetMapping("/")
	public List<UserEntity> home() {
		List<UserEntity> list = new ArrayList<>();
		list.add(service.findHer());
		list.add(service.findMe());
		return list;
	}	
	
}
