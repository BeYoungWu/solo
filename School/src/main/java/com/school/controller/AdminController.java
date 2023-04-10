package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = { "/admin" })
public class AdminController {

//	@Autowired
//	@Qualifier("adminService")
//	private AdminService adminService;
	
	// 교직원소개 관리 페이지
	@GetMapping(path = { "/aboutAdmin" })
	public String aboutAdmin() {
		return "/admin/aboutAdmin";
	}
	
	// 교직원소개 등록 및 편집
//	@PostMapping(path = { "/aboutAdmin" })
//	public String updateAbout() {
//		return "";
//	}
	
	// 교육목표 관리 페이지
	@GetMapping(path = { "/purposeAdmin" })
	public String purposeAdmin() {
		return "/admin/purposeAdmin";
	}
	
	// 교육목표 등록 및 편집
//		@PostMapping(path = { "/purposeAdmin" })
//		public String updatePurpose() {
//			return "";
//		}
	
	// 학교연혁 관리 페이지
	@GetMapping(path = { "/historyAdmin" })
	public String historyAdmin() {
		return "/admin/historyAdmin";
	}
	
	// 학교연혁 등록 및 편집
//	@PostMapping(path = { "historyAdmin" })
//	public String updateHistory() {
//		return "";
//	}
	
	// 학교현황 관리 페이지
	@GetMapping(path = { "/currentAdmin" })
	public String currentAdmin() {
		return "/admin/currentAdmin";
	}
	
	// 학교현황 등록 및 편집
//	@PostMapping(path = { "/currentAdmin" })
//	public String updateCurrent() {
//		return "";
//	}
	
	// 학교상징 관리 페이지
	@GetMapping(path = { "/symbolAdmin" })
	public String symbolAdmin() {
		return "/admin/symbolAdmin";
	}
	
	// 학교상징 등록 및 편집
//	@PostMapping(path = { "/symbolAdmin" })
//	public String updateSymbol() {
//		return "";
//	}
	
	// 학교교가 관리 페이지
	@GetMapping(path = { "/songAdmin" })
	public String songAdmin() {
		return "/admin/songAdmin";
	}
	
	// 학교교가 등록 및 편집
//	@PostMapping(path = { "/songAdmin" })
//	public String updateSong() {
//		return "";
//	}
	
	// 학교일정 관리 페이지
	@GetMapping(path = { "/scheduleAdmin" })
	public String scheduleAdmin() {
		return "/admin/scheduleAdmin";
	}
	
	// 학교일정 등록 및 편집
	@PostMapping(path = { "/scheduleAdmin" })
	public String updateSchedule() {
		return "";
	}
	
}

















