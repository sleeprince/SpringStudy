package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.service.JpaService;
import com.app.service.UserService;

@SpringBootApplication
public class ConsoleJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleJpaApplication.class, args);
	}
	
	@Autowired
	private JpaService jpaService;
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		boolean type = false;
		if(type) {
			jpaService.run();
		} else {
			userService.run();
		}
	}

}
