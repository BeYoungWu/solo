package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

	// 로그인 페이지 이동
	@GetMapping(path = { "/login" })
	public String showLoginForm() {
		return "account/login";
	}
	
	// 로그인
	@PostMapping(path = { "/login" })
	public String login() {
		return "redirect:/home";
	}
	
	// 회원가입 페이지 이동
	@GetMapping(path = { "/register" })
	public String showRegisterForm() {
		return "account/register";
	}
	
	// 회원가입
	@PostMapping(path = { "/register" })
	public String register() {
		return "redirect:/login";
	}
	
	
}

















