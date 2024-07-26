package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.dao.ListDao;
import com.spring.dto.TempDTO;

@Service
public class ListService {

	@Autowired
	private ListDao listDao;
	
	public void findAll(Model model) {
		Object type = model.getAttribute("type");
		boolean accept = false;
		if(type != null || !"".equals(type)) {
			if("1".equals(type)) accept = true;
		}
		model.addAttribute("list", listDao.findAll(TempDTO.builder().type(type).accept(accept).build()));
	}
	
	public boolean findOne(String no, Model model) {
		try {
			int num = Integer.parseInt(no);
			model.addAttribute("data", listDao.findOne(TempDTO.builder().no(num).build()));
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	public void edit(TempDTO dto) {
		listDao.edit(dto);
	}
	
	public boolean accept(String no, String accept) {
		try {
			int num = Integer.parseInt(no);
			boolean acc = ("1".equals(accept))? true:false;		
			listDao.accept(TempDTO.builder().no(num).accept(acc).build());
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	public int save(TempDTO dto) {
		return listDao.save(dto).getNo();
	}
}
