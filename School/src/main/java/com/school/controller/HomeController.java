package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.school.service.BoardService;

@Controller
public class HomeController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
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
	////////////////////////////////////////////////////////////
	
	// 문의
	@GetMapping(path = { "/contact" })
	public String contact() {
		return "contact";
	}
	
	////////////////////////////////////////////////////////////
	
}
