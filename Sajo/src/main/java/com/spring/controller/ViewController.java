package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myDTO.MyDTO;
import com.spring.service.ViewService;

@Controller
public class ViewController {
	
	@Autowired
	private ViewService viewService;
	
	@GetMapping("/list")
	public String list(Model model) {
		viewService.findAll(model);
		return "list";
	}
	
	@GetMapping("/list/{type}")
	public String toList(@PathVariable("type") Object type, RedirectAttributes ratt){
		ratt.addFlashAttribute("type", type);
		return "redirect:/list";
	}
	
	@GetMapping("/detail")
	public String detail() {		
		return "redirect:/list";
	}
	
	@GetMapping("/detail/{no}")
	public String getDetail(@PathVariable("no") String no,  Model model) {		
		if(viewService.findOne(model, no))
			return "detail";
		else
			return "redirect:/list";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute MyDTO dto) {	
		System.out.println(dto);
		if(viewService.update(dto) == 1)
			return "redirect:/detail/"+ dto.getNo();
		else
			return "redirect:/list";
	}
	
	@GetMapping("detail/{no}/{accept}")
	public String accept(@PathVariable("no") String no, @PathVariable("accept") String accept) {
		if(viewService.accept(no, accept) == 1)
			return "redirect:/detail/" + no;
		else
			return "redirect:/list";
	}
	
	@GetMapping("/new")
	public String aWholeNewWorld() {		
		return "new";	
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute MyDTO dto) {
		if(dto.getTitle() != null || dto.getContent() != null) {			
			return "redirect:/detail/" + viewService.save(dto).getNo();
		}else {
			return "redirect:/new";
		}
			
	}
	
}
