package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.dao.TempDao;
import com.spring.dto.TempDTO;

@Service
public class V1Service {

  @Autowired
  private TempDao dao;

  // List 화면 데이터 가져오는 메소드 : 조건 accept 상태값 유무로 3가지 방법으로 출력
  public void findAll(Model model) {
    Object type = model.getAttribute("type");
    boolean accept = false;
    if(type != null || !"".equals(type)) {
      accept = ("1".equals(type)) ? true : false;
    }
    model.addAttribute("list", dao.findAll(TempDTO.builder().type(type).accept(accept).build()));
  }

  // New 화면에서 Submit 발생시 실행되는 메소드 : 조건 DTO 모델에 담겨 있는 데이터를 Table에 전달 후 생성된 식별자 no를 돌려 받아 출력
  public TempDTO save(TempDTO dto) {
    return dao.save(dto);
  }

  // Detail 화면에서 Submit 발생시 실행되는 메소드 : 조건 DTO 모델에 담겨 있는 데이터를 Table에 수정 후 식별자 no를 이용하여 다시 출력
  public TempDTO edit(TempDTO dto) {
    return dao.edit(dto);
  }

  // Detail 화면 데이터 가져오는 메소드 : 조건 데이터 식별하기 위한 no를 확인 후 하나의 정보만 출력
  public boolean findOne(String str, Model model) {
    try {
      int no = Integer.parseInt(str);
      model.addAttribute("dto", dao.findOne(TempDTO.builder().no(no).build()));
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  // Detail 화면 승인 여부 제어하는 메소드 : 조건 식별자인 no와 승인인 accept 값을 확인 후 Table에 수정 후 식별자 no를 이용하여 다시 출력
  public boolean accept(String str1, String str2) {
    try {
      int no = Integer.parseInt(str1);
      boolean accept = ("1".equals(str2)) ? true : false;
      dao.accept(TempDTO.builder().no(no).accept(accept).build());
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

}
