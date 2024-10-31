package com.folder.bean;

import org.springframework.stereotype.Component;

//@Component
public class Data2Imp implements Data {

	@Override
	public int a() {
		return 10;
	}

	@Override
	public String b() {
		return "십";
	}

}
