package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(path= {"/", "/home" })
	public String home() {
		return "home";
	}
	
	@GetMapping(path = {"/about"})
	public String about() {
		return "about";
	}
	
	@GetMapping(path = {"/news"})
	public String news() {
		return "news";
	}
	
	@GetMapping(path = {"/teacherBoard"})
	public String teacherBoard() {
		return "teacherBoard";
	}
	
	@GetMapping(path = {"/parentBoard"})
	public String parentBoard() {
		return "parentBoard";
	}
	
	@GetMapping(path = {"/studentBoard"})
	public String studentBoard() {
		return "studentBoard";
	}
	
	@GetMapping(path = {"/contact"})
	public String contact() {
		return "contact";
	}
	
}
