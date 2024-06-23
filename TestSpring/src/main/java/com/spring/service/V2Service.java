package com.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.dao.TempDao;
import com.spring.dto.TempDTO;

@Service
public class V2Service {

  @Autowired
  private TempDao dao;

  // List 화면 데이터 가져오는 메소드 : 조건 accept 상태값 유무로 3가지 방법으로 출력
  public void findAll(Model model, HttpServletRequest req) {
    String type = req.getParameter("type");
    boolean accept = false;
    if(type != null || !"".equals(type)) {
      accept = ("1".equals(type)) ? true : false;
    }
    model.addAttribute("list", dao.findAll(TempDTO.builder().type(type).accept(accept).build()));
  }

  // Detail 화면 데이터 가져오는 메소드 : 조건 데이터 식별하기 위한 no를 확인 후 하나의 정보만 출력
  public boolean findOne(HttpServletRequest req, Model model) {
    try {
      int no = Integer.parseInt(req.getParameter("no"));
      String type = req.getParameter("type");
      if(type != null) {
        // Detail 화면 승인 여부 제어 : 조건 식별자인 no와 승인인 accept 값을 확인 후 Table에 수정 후 식별자 no를 이용하여 다시 출력
        boolean accept = ("1".equals(type)) ? true : false;
        dao.accept(TempDTO.builder().no(no).accept(accept).build());
      }
      model.addAttribute("dto", dao.findOne(TempDTO.builder().no(no).build()));
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  // Detail 화면에서 Submit 발생시 실행되는 메소드 : 조건 DTO 모델에 담겨 있는 데이터를 Table에 수정 후 식별자 no를 이용하여 다시 출력
  public TempDTO edit(HttpServletRequest req) {
    try {
      int no = Integer.parseInt(req.getParameter("no"));
      String title = req.getParameter("title");
      String content = req.getParameter("content");
      return dao.edit(TempDTO.builder().no(no).title(title).content(content).build());
    } catch (NumberFormatException e) {
      return null;
    }
  }

  // New 화면에서 Submit 발생시 실행되는 메소드 : 조건 DTO 모델에 담겨 있는 데이터를 Table에 전달 후 생성된 식별자 no를 돌려 받아 출력
  public TempDTO save(HttpServletRequest req) {
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    if(title != null || !"".equals(title)) {
      return dao.save(TempDTO.builder().title(title).content(content).build());
    }
    return null;
  }

}
