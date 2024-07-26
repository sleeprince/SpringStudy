package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dto.TempDTO;
import com.spring.service.ListService;

@Controller
public class ListController {

	@Autowired
	private ListService listService;
	
	@GetMapping("/list")
	public String list(Model model) {
		listService.findAll(model);
		return "list";				
	}
	
	@GetMapping("/list/{type}")
	public String listAccept(@PathVariable Object type, RedirectAttributes ratt) {
		ratt.addFlashAttribute("type", type);
		return "redirect:/list";
	}
	
	@GetMapping("/detail")
	public String detail() {		
		return "redirect:/list";
	}
	
	@GetMapping("detail/{no}")
	public String realDetail(@PathVariable("no") String no, Model model) {
		if(listService.findOne(no, model)) {
			return "detail";
		}else {
			return "redirect:/list";			
		}
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute TempDTO dto) {
		if(dto.getTitle() != null || dto.getContent() != null) {
			listService.edit(dto);
			return "redirect:/detail/" + dto.getNo();
		}else {
			return "redirect:/list";			
		}
				
	}
	
	@GetMapping("/acceptMe/{no}/{accept}")
	public String acceptMe(@PathVariable String no, @PathVariable String accept) {
		if(listService.accept(no, accept)) {
			return "redirect:/detail/" + no;
		}else {			
			return "redirect:/list";
		}			
	}
	
	@GetMapping("/new")
	public String newInfo() {return "new";}
	
	@PostMapping("/save")
	public String save(@ModelAttribute TempDTO dto) {
		if(dto.getTitle() != null || dto.getContent() != null) {			
			return "redirect:/detail/" + listService.save(dto);
		}else {
			return "redirect:/list";			
		}
	}
	
}
