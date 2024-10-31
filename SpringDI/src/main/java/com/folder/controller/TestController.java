package com.folder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.folder.bean.Test1;
import com.folder.service.TestService;
import com.folder.util.DataUtil;

@Controller
public class TestController {
	
	@Autowired
	private TestService ts;
	
//	public TestController() {
//		ts = new TestService();
//	}
	
	@Autowired
	private DataUtil du;
	
	@Autowired
	private Test1 test1;
	
	@GetMapping("/test")
	public void getMethodName() {
		int a = ts.test();
		//System.out.println(a);
		//System.out.println(du.a);
		System.out.println(test1.test());
	}
	

}
