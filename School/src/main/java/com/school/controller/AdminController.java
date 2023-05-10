package com.school.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.school.common.Util;
import com.school.dto.FileDto;
import com.school.dto.TeacherDto;
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
	        resultMapEntry.put("fileType", file.getFileType());
	    }
		
		// 교직원 수 구하기
		int teacherSize = teachers.size();
		
		model.addAttribute("subjects", subjects);
		model.addAttribute("ts", teacherSize);
		model.addAttribute("tnf", tnf);
		
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
	            fileDto.setFileType(1);
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

	// 교직원 수정 모달창 해당 교직원 정보 가져오기
	@GetMapping(path = { "/getTeacherData" })
	@ResponseBody
	public Map<String, Object> getTeacherData(int teacherNo, Long fileNo) {
		
		// teacherNo에 해당하는 Dto 찾아오기
		TeacherDto teacher = adminService.findTeacherByNo(teacherNo);
		
		// fileNo에 해당하는 Dto 찾아오기
		FileDto file = fileService.getFile(fileNo);
		
		// 두 Dto 하나의 Hashmap으로 합치기
		Map<String, Object> tnf = new HashMap<>();
		tnf.put("teacher", teacher);
		tnf.put("file", file);
		
		return tnf;
	}
	
	// 교직원 수정
	@PostMapping(path = { "/modifyTeacher" })
	public String modifyTeacher(TeacherDto teacher, String subjectSelboxDirect, Long prevFileNo, @RequestParam("modifyTeacherImg") MultipartFile modFile) {
		
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
			if (modFile.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = modFile.getOriginalFilename();
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
	            modFile.transferTo(new File(filePath));
	            
	            FileDto fileDto = new FileDto();
	            fileDto.setUserFileName(userFileName);
	            fileDto.setSavedFileName(filename);
	            fileDto.setFileType(1);
	            fileDto.setFilePath(filePath);
	
	            fileService.deleteFile(prevFileNo);
	            Long fileNo = fileService.saveFile(fileDto);
	            teacher.setFileNo(fileNo);
			}
			adminService.modifyTeacher(teacher);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/admin/aboutAdmin";
	}
	
	// 교직원 삭제
	@PostMapping(path = { "/deleteTeacher" })
	public String deleteTeacher(int teacherNo) {
		
		adminService.deleteTeacher(teacherNo);
		
		return "redirect:/admin/aboutAdmin";
	}
	
	// 교육목표 관리 페이지
	@GetMapping(path = { "/purposeAdmin" })
	public String purposeAdmin(Model model) {
		
		FileDto file = fileService.getFileByFileType(2);
		
		model.addAttribute("file", file);
		
		return "/admin/purposeAdmin";
	} 
	
	// 교육목표 등록
	@PostMapping(path = { "/registerPurpose" })
	public String updatePurpose(@RequestParam("imgFile") MultipartFile file) {
		
		// 첨부파일
		try {
			if (file.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = file.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\purpose";
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
	            fileDto.setFileType(2);
	            fileDto.setFilePath(filePath);
	
	            fileService.saveFile(fileDto);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/admin/purposeAdmin";
	}
	
	// 교육목표 수정 모달창 등록된 파일 정보 가져오기
	@GetMapping(path = { "/getPurposeData" })
	@ResponseBody
	public FileDto getPurposeData(Model model) {
		
		FileDto file = fileService.getFileByFileType(2);
		
		return file;
	}
		
	// 교육목표 수정
	@PostMapping(path = { "/modifyPurpose" })
	public String modifyPurpose(Long prevFileNo, @RequestParam("imgFile") MultipartFile modFile) {
		
		// 첨부파일
		try {
			if (modFile.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = modFile.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\purpose";
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
	            modFile.transferTo(new File(filePath));
	            
	            FileDto fileDto = new FileDto();
	            fileDto.setUserFileName(userFileName);
	            fileDto.setSavedFileName(filename);
	            fileDto.setFileType(2);
	            fileDto.setFilePath(filePath);
	            
	            fileService.deleteFile(prevFileNo);
	            fileService.saveFile(fileDto);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return "redirect:/admin/purposeAdmin";
	}
	
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

















