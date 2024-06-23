package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.TempDTO;
import com.spring.service.V2Service;

@Controller
@RequestMapping("/v2")
public class V2Controller {

  @Autowired
  private V2Service v2;

  @GetMapping("/new")
  public String input() {return "v2/new";}

  @GetMapping("/list")
  public String list(Model model, HttpServletRequest req) {
    v2.findAll(model, req);
    return "v2/list";
  }

  @GetMapping("/detail")
  public String detail(HttpServletRequest req, Model model) {
    if(v2.findOne(req, model)) {
      return "v2/detail";
    } else {
      return "redirect:/v2/list";
    }
  }

  @PostMapping("/edit")
  public String edit(HttpServletRequest req) {
    TempDTO dto = v2.edit(req);
    if(dto != null) {
      return "redirect:/v2/detail?no=" + dto.getNo();
    } else {
      return "redirect:/v2/list";
    }
  }

  @PostMapping("/save")
  public String save(HttpServletRequest req) {
    TempDTO dto = v2.save(req);
    if(dto != null) {
      return "redirect:/v2/detail?no=" + dto.getNo();
    } else {
      return "redirect:/v2/new";
    }
  }

}
