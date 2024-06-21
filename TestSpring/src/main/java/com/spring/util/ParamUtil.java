package com.spring.util;

import javax.servlet.http.HttpServletRequest;

import com.spring.dto.TempDTO;

public class ParamUtil {
	
	private boolean test;
	
	public TempDTO getParam(HttpServletRequest req) {
		
		int no = Integer.parseInt(req.getParameter("no")); 
		
		
		TempDTO tmp = new TempDTO();
		
		test = false;
		
		return tmp;
	}
}
