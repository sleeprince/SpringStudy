package com.folder.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Data1Imp implements Data {
	
	@Value("3")
	private int a;
	
	@Value("삼")
	private String b;

	@Override
	public int a() {
		return a;
	}

	@Override
	public String b() {
		return b;
	}

}
