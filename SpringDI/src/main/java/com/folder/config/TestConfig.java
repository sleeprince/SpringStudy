package com.folder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.folder.bean.Test1;

@Configuration
public class TestConfig {

	@Bean
	public Test1 test1() {
		return new Test1();
	}
	
	
}
