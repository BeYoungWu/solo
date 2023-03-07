package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = { "/account" })
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
	
	// 아이디 찾기 페이지 이동
	@GetMapping(path = { "/findId" })
	public String showFindIdForm() {
		return "account/findId";
	}
	
	// 비밀번호 찾기 페이지 이동
	@GetMapping(path = { "/findPasswd" })
	public String showFindPasswdForm() {
		return "account/findPasswd";
	}
	
	
}

















