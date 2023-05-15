package com.school.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.school.common.Util;
import com.school.dto.FileDto;
import com.school.dto.TeacherDto;
import com.school.service.AdminService;
import com.school.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
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
		List<TeacherDto> teachers = adminService.findAllTeachers();
		List<FileDto> files = fileService.getTeacherFiles();

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
		
		model.addAttribute("subjects", subjects);
		model.addAttribute("ts", teacherSize);
		model.addAttribute("tnf", tnf2);
		
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
	public String modifyTeacher(TeacherDto teacher, String modifySubjectSelboxDirect, Long prevFileNo, @RequestParam("modifyTeacherImg") MultipartFile modFile) {
		
		// 교사 과목 선택사항
		String subject = null;
		if (modifySubjectSelboxDirect == null || modifySubjectSelboxDirect.length() == 0) { // 교사 과목 직접입력 x
			subject = teacher.getSubject();
		} else { // 교사 과목 직접입력 o
			subject = modifySubjectSelboxDirect;
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
	            adminService.modifyTeacher(teacher);
			} else { // 내용은 변경했지만 첨부파일은 수정하지 않은 경우
				teacher.setFileNo(prevFileNo);
				adminService.modifyTeacher(teacher);
			}
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
	public String registerPurpose(@RequestParam("imgFile") MultipartFile file) {
		
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
	public String modifyPurpose(Long prevFileNo, @RequestParam("modFile") MultipartFile modFile) {
		
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
	
	// 교육목표 삭제
	@GetMapping(path = { "/deletePurpose" })
	public String deletePurpose(Long fileNo) {
		
		fileService.deleteFile(fileNo);
		
		return "redirect:/admin/purposeAdmin";
	}
	
	// 학교연혁 관리 페이지
	@GetMapping(path = { "/historyAdmin" })
	public String historyAdmin(Model model) {
		
		FileDto file = fileService.getFileByFileType(3);
		
		model.addAttribute("file", file);
		
		return "/admin/historyAdmin";
	}
	
	// 학교연혁 등록
	@PostMapping(path = { "registerHistory" })
	public String registerHistory(@RequestParam("imgFile") MultipartFile file) {
		
		// 첨부파일
		try {
			if (file.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = file.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\history";
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
	            fileDto.setFileType(3);
	            fileDto.setFilePath(filePath);
	
	            fileService.saveFile(fileDto);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/admin/historyAdimin";
	}
	
	// 학교연혁 수정 모달창 등록된 파일 정보 가져오기
	@GetMapping(path = { "/getHistoryData" })
	@ResponseBody
	public FileDto getHistoryData(Model model) {
		
		FileDto file = fileService.getFileByFileType(3);
		
		return file;
	}
		
	// 학교연혁 수정
	@PostMapping(path = { "/modifyHistory" })
	public String modifyHistory(Long prevFileNo, @RequestParam("modFile") MultipartFile modFile) {
		
		// 첨부파일
		try {
			if (modFile.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = modFile.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\history";
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
	            fileDto.setFileType(3);
	            fileDto.setFilePath(filePath);
	            
	            fileService.deleteFile(prevFileNo);
	            fileService.saveFile(fileDto);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return "redirect:/admin/historyAdmin";
	}
	
	// 학교연혁 삭제
	@GetMapping(path = { "/deleteHistory" })
	public String deleteHistory(Long fileNo) {
		
		fileService.deleteFile(fileNo);
		
		return "redirect:/admin/historyAdmin";
	}
	
	// 학교현황 관리 페이지
	@GetMapping(path = { "/currentAdmin" })
	public String currentAdmin(Model model) {
		
		FileDto file = fileService.getFileByFileType(4);
		
		model.addAttribute("file", file);
		
		return "/admin/currentAdmin";
	}

	// 학교현황 등록
	@PostMapping(path = { "registerCurrent" })
	public String registerCurrent(@RequestParam("imgFile") MultipartFile file) {
		
		// 첨부파일
		try {
			if (file.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = file.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\current";
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
	            fileDto.setFileType(4);
	            fileDto.setFilePath(filePath);
	
	            fileService.saveFile(fileDto);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/admin/currentAdimin";
	}
	
	// 학교현황 수정 모달창 등록된 파일 정보 가져오기
	@GetMapping(path = { "/getCurrentData" })
	@ResponseBody
	public FileDto getCurrentData(Model model) {
		
		FileDto file = fileService.getFileByFileType(4);
		
		return file;
	}
		
	// 학교현황 수정
	@PostMapping(path = { "/modifyCurrent" })
	public String modifyCurrent(Long prevFileNo, @RequestParam("modFile") MultipartFile modFile) {
		
		// 첨부파일
		try {
			if (modFile.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = modFile.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\current";
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
	            fileDto.setFileType(4);
	            fileDto.setFilePath(filePath);
	            
	            fileService.deleteFile(prevFileNo);
	            fileService.saveFile(fileDto);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return "redirect:/admin/currentAdmin";
	}
	
	// 학교현황 삭제
	@GetMapping(path = { "/deleteCurrent" })
	public String deleteCurrent(Long fileNo) {
		
		fileService.deleteFile(fileNo);
		
		return "redirect:/admin/currentAdmin";
	}
	
	// 학교상징 관리 페이지
	@GetMapping(path = { "/symbolAdmin" })
	public String symbolAdmin(Model model) {
		
		FileDto file = fileService.getFileByFileType(5);
		
		model.addAttribute("file", file);
		
		return "/admin/symbolAdmin";
	}
	
	// 학교상징 등록
	@PostMapping(path = { "registerSymbol" })
	public String registerSymbol(@RequestParam("imgFile") MultipartFile file) {
		
		// 첨부파일
		try {
			if (file.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = file.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\symbol";
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
	            fileDto.setFileType(5);
	            fileDto.setFilePath(filePath);
	
	            fileService.saveFile(fileDto);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/admin/symbolAdimin";
	}
	
	// 학교상징 수정 모달창 등록된 파일 정보 가져오기
	@GetMapping(path = { "/getSymbolData" })
	@ResponseBody
	public FileDto getSymbolData(Model model) {
		
		FileDto file = fileService.getFileByFileType(5);
		
		return file;
	}
		
	// 학교상징 수정
	@PostMapping(path = { "/modifySymbol" })
	public String modifySymbol(Long prevFileNo, @RequestParam("modFile") MultipartFile modFile) {
		
		// 첨부파일
		try {
			if (modFile.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = modFile.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\symbol";
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
	            fileDto.setFileType(5);
	            fileDto.setFilePath(filePath);
	            
	            fileService.deleteFile(prevFileNo);
	            fileService.saveFile(fileDto);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return "redirect:/admin/symbolAdmin";
	}
	
	// 학교상징 삭제
	@GetMapping(path = { "/deleteSymbol" })
	public String deleteSymbol(Long fileNo) {
		
		fileService.deleteFile(fileNo);
		
		return "redirect:/admin/symbolAdmin";
	}
	
	// 학교교가 관리 페이지
	@GetMapping(path = { "/songAdmin" })
	public String songAdmin(Model model) {
		
		FileDto file = fileService.getFileByFileType(6);
		
		model.addAttribute("file", file);
		
		return "/admin/songAdmin";
	}
	
	// 학교교가 등록
	@PostMapping(path = { "registerSong" })
	public String registerSong(@RequestParam("imgFile") MultipartFile file) {
		
		// 첨부파일
		try {
			if (file.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = file.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\song";
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
	            fileDto.setFileType(6);
	            fileDto.setFilePath(filePath);
	
	            fileService.saveFile(fileDto);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/admin/songAdimin";
	}
	
	// 학교교가 수정 모달창 등록된 파일 정보 가져오기
	@GetMapping(path = { "/getSongData" })
	@ResponseBody
	public FileDto getSongData(Model model) {
		
		FileDto file = fileService.getFileByFileType(6);
		
		return file;
	}
		
	// 학교교가 수정
	@PostMapping(path = { "/modifySong" })
	public String modifySong(Long prevFileNo, @RequestParam("modFile") MultipartFile modFile) {
		
		// 첨부파일
		try {
			if (modFile.getOriginalFilename().length() != 0) { // 변경된 첨부파일이 있을 때
				String userFileName = modFile.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\song";
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
	            fileDto.setFileType(6);
	            fileDto.setFilePath(filePath);
	            
	            fileService.deleteFile(prevFileNo);
	            fileService.saveFile(fileDto);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return "redirect:/admin/songAdmin";
	}
	
	// 학교교가 삭제
	@GetMapping(path = { "/deleteSong" })
	public String deleteSong(Long fileNo) {
		
		fileService.deleteFile(fileNo);
		
		return "redirect:/admin/songAdmin";
	}
	
}

















