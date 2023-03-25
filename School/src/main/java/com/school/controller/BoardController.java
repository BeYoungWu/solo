package com.school.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.school.dto.BoardDto;
import com.school.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	// 글쓰기 폼
	@GetMapping(path = { "/write" })
	public String showWriteForm() {
		
		
		return "/write";
	}
	
	// 글 게시하기
	@PostMapping(path = { "/write" })
	public String write(BoardDto board, HttpServletRequest request, HttpSession session) {
		
		System.out.println(board);
		
		boardService.insertBoard(board);
		
		return "/home";
	}
	
}
