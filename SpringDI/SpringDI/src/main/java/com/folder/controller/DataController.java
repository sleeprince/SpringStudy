package com.folder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;

import com.folder.bean.Data;
import com.folder.bean.Data1Imp;
import com.folder.bean.Data2Imp;
import com.folder.dto.DataDTO;

import jakarta.servlet.ServletRequest;

@RestController
@RequestMapping("/data")
public class DataController {

	@Autowired
	@Qualifier("Data1Imp")
	private Data data1;
	
	@Autowired
	@Qualifier("Data2Imp")
	private Data data2;
	
	@GetMapping("/test1")
	public String test1() {
		return data1.b();
	}
	
	@GetMapping("/test2")
	public int test2() {
		return data2.a();
	}
	
	@GetMapping("/test3")
	public DataDTO test3(ServletRequest req) {
//		System.out.println(req.getParameter("type"));
		// Data1 값으로 변경 하세요.
		int a = 10;
		String b = "열";
		if("data1".equals( req.getParameter("type") )) {
			a = data1.a();
			b = data1.b();
		} else {
			a = data2.a();
			b = data2.b();
		}
		return DataDTO.builder()
				.a(a)
				.b(b)
				.build();
	}
	
	@GetMapping(value = {"/test4", "/test4/{type}"})
	public DataDTO test4(@PathVariable(name="type", required = false) String type) {
		int a = 10;
		String b = "열";
		if("data1".equals( type )) {
			a = data1.a();
			b = data1.b();
		} else {
			a = data2.a();
			b = data2.b();
		}
		return DataDTO.builder()
				.a(a)
				.b(b)
				.build();
	}
}
