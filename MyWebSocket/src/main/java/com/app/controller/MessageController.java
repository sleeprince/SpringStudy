package com.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MessageController {
	
	@MessageMapping("/set")
	public void conn(String msg) {
		log.info("Message: {}", msg);
	}

}
