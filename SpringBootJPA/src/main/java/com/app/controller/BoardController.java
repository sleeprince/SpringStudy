package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.BoardEntity;
import com.app.repository.BoardEntityRepository;
import com.app.repository.Boards;

@Controller
public class BoardController {

	@GetMapping("/boards")
	public String boards() {
		return "board";
	}
	
	@Autowired
	private BoardEntityRepository bRepository;
	
	@ResponseBody
	@GetMapping("/boardAll")
	public List<BoardEntity> boardAll() {
//		return bRepository.getBoards();
//		return bRepository.findAll();
		return bRepository.getBoardAll();
	}
	
}
