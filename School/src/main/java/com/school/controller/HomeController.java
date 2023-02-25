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
	
	@GetMapping(path = {"/courses"})
	public String courses() {
		return "courses";
	}
	
	@GetMapping(path = {"/portfolio"})
	public String portfolio() {
		return "portfolio";
	}
	
	@GetMapping(path = {"/pricing"})
	public String pricing() {
		return "pricing";
	}
	
	@GetMapping(path = {"/contact"})
	public String contact() {
		return "contact";
	}
	
}
