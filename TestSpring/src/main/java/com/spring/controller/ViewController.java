package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.dto.TempDTO;
import com.spring.service.ViewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {
	
	private final ViewService viewService;
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("dto", viewService.test(TempDTO.builder().no(1).build()));
		return "test";
	}

}
