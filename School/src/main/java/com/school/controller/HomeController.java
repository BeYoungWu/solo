package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping(path = { "/", "/home" })
	public String home() {
		return "home";
	}
	
	////////////////////////////////////////////////////////////
	
	// 학교소개 (교직원소개)
	@GetMapping(path = { "/about" })
	public String about() {
		return "about";
	}
	// 교육목표
	@GetMapping(path = { "/purpose" })
	public String purpose() {
		return "about/purpose";
	}
	// 학교연혁
	@GetMapping(path = { "/history" })
	public String history() {
		return "about/history";
	}
	// 학교현황
	@GetMapping(path = { "/current" })
	public String current() {
		return "about/current";
	}
	// 학교상징
	@GetMapping(path = { "/symbol" })
	public String symbol() {
		return "about/symbol";
	}
	// 학교교가
	@GetMapping(path = { "/song" })
	public String song() {
		return "about/song";
	}
	// 학교교육계획
	@GetMapping(path = { "/plan" })
	public String plan() {
		return "about/plan";
	}
	////////////////////////////////////////////////////////////
	
	// 글쓰기 폼
	@GetMapping(path = { "/write" })
	public String showWriteForm() {
		return "write";
	}
	
	// 글 게시하기
//	@PostMapping(path = { "/write" })
//	public String write() {
//		return "";
//	}
	
	
	////////////////////////////////////////////////////////////
	
	// 알림마당
	@GetMapping(path = { "/news" })
	public String news() {
		return "news";
	}
	////////////////////////////////////////////////////////////
	
	// 교사마당
	@GetMapping(path = { "/teacherBoard" })
	public String teacherBoard() {
		return "teacherBoard";
	}
	////////////////////////////////////////////////////////////
	
	// 학부모마당
	@GetMapping(path = { "/parentBoard" })
	public String parentBoard() {
		return "parentBoard";
	}
	////////////////////////////////////////////////////////////
	
	// 학생마당
	@GetMapping(path = { "/studentBoard" })
	public String studentBoard() {
		return "studentBoard";
	}
	////////////////////////////////////////////////////////////
	
	// 문의
	@GetMapping(path = { "/contact" })
	public String contact() {
		return "contact";
	}
	
	////////////////////////////////////////////////////////////
	
}
