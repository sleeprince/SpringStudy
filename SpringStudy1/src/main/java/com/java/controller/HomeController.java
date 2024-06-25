package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("txt", "전송 데이터");
		return "home";
	}
	
}
