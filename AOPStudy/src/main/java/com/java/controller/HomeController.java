package com.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.HomeDTO;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "Welcome to the AOP world!";
	}
	
	@GetMapping("/dto")
	public HomeDTO homeDTO(HomeDTO dto) {
		return dto;
	}
	
	
}
