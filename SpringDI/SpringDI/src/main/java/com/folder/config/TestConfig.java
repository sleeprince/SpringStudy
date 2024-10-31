package com.folder.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.folder.bean.Data;
import com.folder.bean.Data1Imp;
import com.folder.bean.Data2Imp;
import com.folder.bean.Test1;

@Configuration
public class TestConfig {

	@Bean
	public Test1 test1() {
		return new Test1();
	}
	
	@Bean
	@Qualifier("Data1Imp")
	public Data data1Imp() {
		return new Data1Imp();
	}
	
	@Bean
	@Qualifier("Data2Imp")
	public Data data2Imp() {
		return new Data2Imp();
	}
	
}
