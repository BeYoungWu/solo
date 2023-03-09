package com.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.dto.AccountDto;
import com.school.service.AccountService;

@Controller
@RequestMapping(path = { "/account" })
public class AccountController {

	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	
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
	
	// 로그인 페이지 이동
	@GetMapping(path = { "/login" })
	public String showLoginForm() {
		return "account/login";
	}
	
	// 로그인
	@PostMapping(path = { "/login" })
	public String login(String userId, String passwd, HttpSession session, Model model) {
		
		AccountDto account = accountService.findUserByIdAndPasswd(userId, passwd);
		
		return "redirect:/home";
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

















