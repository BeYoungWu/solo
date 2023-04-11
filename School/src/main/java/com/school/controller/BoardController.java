package com.school.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.school.dto.BoardDto;
import com.school.dto.FileDto;
import com.school.service.BoardService;
import com.school.service.FileService;
import com.school.util.MD5Generator;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	@Autowired
	@Qualifier("fileService")
	private FileService fileService;
	
	// 게시글 등록 폼
	@GetMapping(path = { "/write" })
	public String showWriteForm(@RequestParam(defaultValue = "-1") int boardType, Model model) {
		
		if (boardType == -1) {
			return "redirect:/home";
//			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
		}
		
		model.addAttribute("boardType", boardType);
			
		return "/board/write";
	}
	
	// 게시글 등록
	@PostMapping(path = { "/write" })
	public String write(@RequestParam(defaultValue = "-1") int boardType, @RequestParam("file") MultipartFile files, BoardDto board, Model model) {
		
		if (boardType == -1) {
			return "redirect:/home";
//			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
		}
		
		// 첨부파일
		try {
			String userFileName = files.getOriginalFilename();
			String filename = new MD5Generator(userFileName).toString();
			/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
            String savePath = System.getProperty("user.dir") + "\\files";
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
            files.transferTo(new File(filePath));

            FileDto fileDto = new FileDto();
            fileDto.setUserFileName(userFileName);
            fileDto.setSavedFileName(filename);
            fileDto.setFilePath(filePath);

            Long fileNo = fileService.saveFile(fileDto);
            board.setFileNo(fileNo);
            boardService.insertBoard(board);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/board/list?boardType=" + boardType;
	}
	
	// 게시글 목록 조회
	@GetMapping(path = { "/list" })
	public String showList(@RequestParam(defaultValue = "-1") int boardType, Model model) {
		
		if (boardType == -1) {
			return "redirect:/home";
//			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
		}
		
		// RequestParam pageNo 해야함
		
		List<BoardDto> boards = boardService.findByBoardType(boardType);
		
		model.addAttribute("boards", boards);
		model.addAttribute("boardType", boardType);
		
		return "/board/list";
	}
	
	// 게시글 상세 조회
	@GetMapping(path = { "/detail" })
	public String showDetail(@RequestParam(defaultValue = "-1") int boardType, @RequestParam(defaultValue = "-1") int boardNo, Model model) {
		
		if (boardType == -1 || boardNo == -1) {
			return "redirect:/home";
//			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
		}
		
		BoardDto board = boardService.findByBoardNo(boardNo);
		FileDto file = fileService.getFile(board.getFileNo());
		
		model.addAttribute("board", board);
		model.addAttribute("boardType", boardType);
		model.addAttribute("file", file);
		
		return "/board/detail";
	}
	
	// 첨부파일 다운로드
	@GetMapping(path = { "/download/{fileNo}" })
	public ResponseEntity<Resource> fileDownload(@PathVariable("fileNo") Long fileNo) throws IOException {

		FileDto file = fileService.getFile(fileNo);
	    Path path = Paths.get(file.getFilePath());
	    Resource resource = new InputStreamResource(Files.newInputStream(path));
	    return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getUserFileName() + "\"")
	            .body(resource);
			
	}
	
	// 게시글 수정 폼
	@GetMapping(path = { "/modify" })
	public String showModify(@RequestParam(defaultValue = "-1") int boardType, @RequestParam(defaultValue = "-1") int boardNo, Model model) {
		
		if (boardType == -1 || boardNo == -1) {
			return "redirect:/home";
//			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
		}
		
		BoardDto board = boardService.findByBoardNo(boardNo);
		
		model.addAttribute("board", board);
		model.addAttribute("boardType", boardType);
		
		return "/board/modify";
	}
	
	// 게시글 수정
	@PostMapping(path = { "/modify" })
	public String modify(@RequestParam(defaultValue = "-1") int boardType, BoardDto board) {
		
		if (boardType == -1) {
			return "redirect:/home";
//			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
		}
		
		boardService.modifyBoard(board);
		
		return "redirect:/board/detail?boardType=" + boardType + "&boardNo=" + board.getBoardNo();
	}
	
	// 게시글 삭제
	@GetMapping(path = { "/delete" })
	public String delete(@RequestParam(defaultValue = "-1") int boardType, @RequestParam(defaultValue = "-1") int boardNo) {
		
		if (boardType == -1 || boardNo == -1) {
			return "redirect:/home";
//			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
		}
		
		boardService.deleteBoard(boardNo);
		
		return "redirect:/board/list?boardType=" + boardType;
	}
	
}
