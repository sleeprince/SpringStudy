package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dto.TempDTO;
import com.spring.service.V1Service;

@Controller
@RequestMapping("/v1")
public class V1Controller {

  @Autowired
  private V1Service v1;

  @GetMapping("/list")
  public String list(Model model) {
    v1.findAll(model);
    return "v1/list";
  }

  @GetMapping("/list/{type}")
  public String list(@PathVariable("type") Object type, RedirectAttributes ratt) {
    ratt.addFlashAttribute("type", type);
    return "redirect:/v1/list";
  }

  @GetMapping("/new")
  public String input() {return "v1/new";}

  @PostMapping("/save")
  public String save(@ModelAttribute TempDTO dto) {
    return "redirect:/v1/detail/" + v1.save(dto).getNo();
  }

  @PostMapping("/edit")
  public String edit(@ModelAttribute TempDTO dto) {
    return "redirect:/v1/detail/" + v1.edit(dto).getNo();
  }

  @GetMapping("/detail")
  public String detail() {return "redirect:/v1/list";}

  @GetMapping("/detail/{no}")
  public String detail(@PathVariable("no") String no, Model model) {
    if(v1.findOne(no, model)) {
      return "v1/detail";
    } else {
      return "redirect:/v1/list";
    }
  }

  @GetMapping("/detail/{no}/{accept}")
  public String detail(@PathVariable("no") String no, @PathVariable("accept") String accept) {
    if(v1.accept(no, accept)) {
      return "redirect:/v1/detail/" + no;
    } else {
      return "redirect:/v1/list";
    }
  }

}
