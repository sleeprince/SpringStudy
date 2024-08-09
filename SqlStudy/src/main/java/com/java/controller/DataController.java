package com.java.controller;

import org.springframework.web.bind.annotation.RestController;

import com.java.service.DataService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class DataController {
	
	@Autowired
	private DataService service;
	
	@PostMapping("/")
	public List<Map<String, Object>> findList() {
		System.out.println("여기 왔다.");
		return service.findList();
	}
	
	@PostMapping("/check/{noticeNum}")
	public String check(@PathVariable("noticeNum") int noticeNum) {
		return service.check(noticeNum);
	}
	
	
}
