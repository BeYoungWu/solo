package com.school.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.school.dto.FileDto;
import com.school.dto.TeacherDto;
import com.school.service.AdminService;
import com.school.service.BoardService;
import com.school.service.FileService;

@Controller
public class HomeController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	@Autowired
	@Qualifier("fileService")
	private FileService fileService;
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	@GetMapping(path = { "/", "/home" })
	public String home() {
		return "/home";
	}
	
	////////////////////////////////////////////////////////////
	
	// 학교소개 (교직원소개)
	@GetMapping(path = { "/about" })
	public String about(Model model) {
		
		// 교직원 목록 불러오기 + 각자의 사진 파일까지
//		List<HashMap<String, Object>> teachers = adminService.findAllTeachers();
		List<TeacherDto> teachers = adminService.findAllTeachers();
		List<FileDto> files = fileService.getTeacherFiles();

		Map<Long, Map<String, Object>> tnf = new HashMap<>();
	    
	    // teachers를 HashMap에 넣기
	    for (TeacherDto teacher : teachers) {
	        Map<String, Object> teacherMap = new HashMap<>();
	        teacherMap.put("teacherNo", teacher.getTeacherNo());
	        teacherMap.put("teacherName", teacher.getTeacherName());
	        teacherMap.put("subject", teacher.getSubject());
	        teacherMap.put("fileNo", teacher.getFileNo());
	        
	        tnf.put(teacher.getFileNo(), teacherMap);
	    }
	    
	    // files를 HashMap에 넣기
	    for (FileDto file : files) {
	        Long fileNo = file.getFileNo();
	        Map<String, Object> resultMapEntry = tnf.get(fileNo);
	        
	        if (resultMapEntry == null) {
	            // Create a new entry for this file
	            resultMapEntry = new HashMap<>();
	            tnf.put(fileNo, resultMapEntry);
	        }
	        
	        resultMapEntry.put("userFileName", file.getUserFileName());
	        resultMapEntry.put("savedFileName", file.getSavedFileName());
	        resultMapEntry.put("filePath", file.getFilePath());
	        resultMapEntry.put("fileType", file.getFileType());
	    }
	    
		// 교직원 수 구하기
		int teacherSize = teachers.size();
		
		model.addAttribute("ts", teacherSize);
		model.addAttribute("tnf", tnf);

		return "/about";
	}
	// 교육목표
	@GetMapping(path = { "/purpose" })
	public String purpose() {
		return "/about/purpose";
	}
	// 학교연혁
	@GetMapping(path = { "/history" })
	public String history() {
		return "/about/history";
	}
	// 학교현황
	@GetMapping(path = { "/current" })
	public String current() {
		return "/about/current";
	}
	// 학교상징
	@GetMapping(path = { "/symbol" })
	public String symbol() {
		return "/about/symbol";
	}
	// 학교교가
	@GetMapping(path = { "/song" })
	public String song() {
		return "/about/song";
	}
	////////////////////////////////////////////////////////////
	
	// 문의
	@GetMapping(path = { "/contact" })
	public String contact() {
		return "/contact";
	}
	
	////////////////////////////////////////////////////////////
	
	// 관리자 페이지
	@GetMapping(path = { "/admin" })
	public String admin() {
		return "/admin";
	}
	
}
