package com.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

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
	public String register(AccountDto account, BindingResult br) { // @Valid에 의해 검출된 오류 정보가 저장된 객체
		
		if (br.hasErrors()) {
			System.out.println("유효성 검사 오류 발생");
			return "account/register";
		}
		
		System.out.println(account);
		
		accountService.register(account);
		
		return "redirect:/account/login";
	}
	
	// 중복아이디 체크
	@PostMapping(path = { "/checkId" })
	public AccountDto checkId(String userId) {
		
		System.out.println(userId);
		AccountDto account = accountService.checkId(userId);
		
		return account;
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
		System.out.println(account);
		if (account != null) {
			session.setAttribute("loginuser", account);
		} else {
			model.addAttribute("loginfail", userId);
			return "account/login";
		}
		
		return "redirect:/home";
	}
	
	// 로그아웃
	@GetMapping(path = { "/logout" })
	public View logout(HttpSession session) {
		
		session.removeAttribute("loginuser");
		
		return new RedirectView("login");		
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

















