package com.school.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.school.common.Util;
import com.school.dto.FileDto;
import com.school.dto.TeacherDto;
import com.school.entity.TeacherEntity;
import com.school.service.AdminService;
import com.school.service.FileService;

@Controller
@RequestMapping(path = { "/admin" })
public class AdminController {

	@Autowired
	@Qualifier("fileService")
	private FileService fileService;
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	// 교직원소개 관리 페이지
	@GetMapping(path = { "/aboutAdmin" })
	public String aboutAdmin(Model model) {
		
		// 과목 목록 불러오기
		List<String> subjects = adminService.findAllSubjects();
		
		// 교직원 목록 불러오기 + 각자의 사진 파일까지
//		List<HashMap<String, Object>> teachers = adminService.findAllTeachers();
		List<TeacherEntity> teachers = adminService.findAllTeachers();
		System.out.println(teachers);
		
		// 교직원 수 구하기
		
		
		model.addAttribute("subjects", subjects);
		model.addAttribute("teachers", teachers);
		
		return "/admin/aboutAdmin";
	}
	
	// 교직원 등록
	@PostMapping(path = { "/registerTeacher" })
	public String regTeacher(TeacherDto teacher, String subjectSelboxDirect, @RequestParam("teacherImg") MultipartFile file) {
		
		// 교사 과목 선택사항
		String subject = null;
		if (subjectSelboxDirect == null || subjectSelboxDirect.length() == 0) { // 교사 과목 직접입력 x
			subject = teacher.getSubject();
		} else { // 교사 과목 직접입력 o
			subject = subjectSelboxDirect;
			teacher.setSubject(subject);
		}
		
		// 첨부파일
		try {
			if (file.getOriginalFilename().length() != 0) {
				String userFileName = file.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\teacher";
	            /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
	            if (!new File(savePath).exists()) {
	                try{
	                    new File(savePath).mkdir();
	                }
	                catch(Exception e){
	                    e.getStackTrace();
	                }
	            }
	            String filePath = savePath + "\\" + filename;
	            file.transferTo(new File(filePath));
	            
	            FileDto fileDto = new FileDto();
	            fileDto.setUserFileName(userFileName);
	            fileDto.setSavedFileName(filename);
	            fileDto.setFilePath(filePath);
	
	            Long fileNo = fileService.saveFile(fileDto);
	            teacher.setFileNo(fileNo);
			}
			adminService.insertTeacher(teacher);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/admin/aboutAdmin";
	}

	// 교직원 수정
//	@PostMapping(path = { "/modifySubject" })
//	public String modifySubject() {
//		
//		
//		return "";
//	}
	
	// 교직원 삭제
//	@PostMapping(path = { "/deleteTeacher" })
//	public String deleteTeacher() {
//		
//		
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

















