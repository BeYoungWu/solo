package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	// 글쓰기 폼
	@GetMapping(path = { "/write" })
	public String showWriteForm() {
		return "write";
	}
	
//	// 글 게시하기
//	@PostMapping(path = { "/write" })
//	public String write() {	
//		return "";
//	}
	
}
