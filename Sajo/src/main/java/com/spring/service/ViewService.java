package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.dao.ViewDao;
import com.spring.myDTO.MyDTO;

@Service
public class ViewService {
	
	@Autowired
	private ViewDao viewDao;
	
	public void findAll(Model model) {
		Object type = model.getAttribute("type");
		boolean accept = false;
		if(type != null || !"".equals(type)) {
			if("1".equals(type)) accept = true;			
		}		
		model.addAttribute("list", viewDao.findAll(MyDTO.builder().type(type).accept(accept).build()));
	}
	
	public boolean findOne(Model model, String no) {
		try {
			int num = Integer.parseInt(no);
			model.addAttribute("data", viewDao.findOne(num));
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	public int update(MyDTO dto) {
		return viewDao.update(dto);
	}
	
	public int accept(String _no, String _accept) {
		try {
			int no = Integer.parseInt(_no);
			boolean accept = ("1".equals(_accept))? true:false;		
			return viewDao.accept(MyDTO.builder().no(no).accept(accept).build());
		}catch(NumberFormatException e){			
			return 0;
		}
	}
	
	public MyDTO save(MyDTO dto) {
		return viewDao.save(dto);
	}
	
}	
