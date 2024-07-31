package com.example.BootTest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.BootTest.dao.T1Dao;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class T1Controller {
	
	@Autowired
	private T1Dao dao;
	
	@GetMapping("/")
	public String home() {
		System.out.println(dao.test());
		return "home";
	}
	
	@PostMapping("/")
	@ResponseBody
	public List<Map> homeData() {	
		System.out.println(dao.findAll().toString());
		return dao.findAll();
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public Map newData() {
		Map<String, Object> map = new HashMap<>();
		map.put("nm", "이름7");
		map.put("age", 20);
		map.put("gend", false);
		dao.insert(map);
		System.out.println(map.toString());
		return map;
	}
	
	@PostMapping("/save")
	public String save() {
		System.out.println("여기 왔다감");
		dao.ok();
		return "redirect:/";
	}
	
	@PostMapping("/rollback")
	public String rollback() {	
		System.out.println("되돌림");
		dao.rollBack();
		return "redirect:/";
	}
	
}
