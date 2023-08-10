package com.school.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.dto.AccountDto;
import com.school.dto.ContactDto;
import com.school.dto.FileDto;
import com.school.dto.TeacherDto;
import com.school.service.AccountService;
import com.school.service.AdminService;
import com.school.service.BoardService;
import com.school.service.ContactService;
import com.school.service.FileService;
import com.school.ui.BoardPager;
import com.school.ui.UserPager;

@Controller
public class HomeController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	@Autowired
	@Qualifier("fileService")
	private FileService fileService;
	
	@Autowired
	@Qualifier("contactService")
	private ContactService contactService;
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	
	@GetMapping(path = { "/", "/home" })
	public String home() {
		return "/home";
	}
	
	////////////////////////////////////////////////////////////
	
	// 학교소개 (교직원소개)
	@GetMapping(path = { "/about" })
	public String about(Model model) {
		
		// 교직원 목록 불러오기 + 각자의 사진 파일까지
		List<TeacherDto> teachers = adminService.findAllTeachers();
		List<FileDto> files = fileService.getTeacherFiles();

		Map<Long, Map<String, Object>> tnf = new HashMap<>();
	    
		// 동명이인 조회 오류 해결중
		// 두 Dto 하나의 Hashmap으로 합치기
		List<Map<String, Object>> tnf1 = new ArrayList<>();
		List<Map<String, Object>> tnf2 = new ArrayList<>();
		
		for (TeacherDto teacher : teachers) {
			Map<String, Object> resultMapEntry = new HashMap<>();
			resultMapEntry.put("teacher", teacher);
			tnf1.add(resultMapEntry);
		}
		
		for (FileDto file : files) {
			for (Map<String, Object> map : tnf1) {
				TeacherDto teacher = (TeacherDto) map.get("teacher");
				Long fileNo = (Long) teacher.getFileNo();
				if (fileNo.equals(file.getFileNo())) {
					map.put("file", file);
					tnf2.add(map);
				} else {
					tnf2.add(map);
				}
			}
		}
		
		// 교직원 수 구하기
		int teacherSize = teachers.size();
		
		model.addAttribute("ts", teacherSize);
		model.addAttribute("tnf", tnf2);

		return "/about";
	}
	// 교육목표
	@GetMapping(path = { "/about/purpose" })
	public String purpose(Model model) {
		
		FileDto file = fileService.getFileByFileType(2);
		
		model.addAttribute("file", file);
		
		return "/about/purpose";
	}
	// 학교연혁
	@GetMapping(path = { "/about/history" })
	public String history(Model model) {
		
		FileDto file = fileService.getFileByFileType(3);
		
		model.addAttribute("file", file);
		
		return "/about/history";
	}
	// 학교현황
	@GetMapping(path = { "/about/current" })
	public String current(Model model) {
		
		FileDto file = fileService.getFileByFileType(4);
		
		model.addAttribute("file", file);
		
		return "/about/current";
	}
	// 학교상징
	@GetMapping(path = { "/about/symbol" })
	public String symbol(Model model) {
		
		FileDto file = fileService.getFileByFileType(5);
		
		model.addAttribute("file", file);
		
		return "/about/symbol";
	}
	// 학교교가
	@GetMapping(path = { "/about/song" })
	public String song(Model model) {
		
		FileDto file = fileService.getFileByFileType(6);
		
		model.addAttribute("file", file);
		
		return "/about/song";
	}
	////////////////////////////////////////////////////////////
	
	// 문의
	@GetMapping(path = { "/contact" })
	public String contact() {
		return "/contact";
	}
	
	// 문의 등록
	@PostMapping(path = { "/sendContact" })
	public String sendContact(ContactDto contact) {

		contactService.registerContact(contact);
		
		return "redirect:/contact";
	}
	
	////////////////////////////////////////////////////////////
	
	private final int PAGE_SIZE = 20; 	// 한 페이지에 표시되는 데이터 개수
	private final int PAGER_SIZE = 5;	// 한 번에 표시할 페이지 번호 개수
	private final String LINK_URL = "admin"; // 페이지 번호를 클릭했을 때 이동할 페이지 경로
	
	// 관리자 페이지
	@GetMapping(path = { "/admin" })
	public String admin(@RequestParam(defaultValue = "-1") int pageNo, Model model) {
		
		List<AccountDto> users = accountService.findAllUsers();
		Long userCount = accountService.countAllUser();
		
		UserPager pager = new UserPager(userCount, pageNo, PAGE_SIZE, PAGER_SIZE, LINK_URL);
		
		model.addAttribute("users", users);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pager", pager);
		
		return "/admin";
	}
	
}
