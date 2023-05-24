package com.school.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;

import com.school.common.Util;
import com.school.dto.BoardDto;
import com.school.dto.FileDto;
import com.school.service.BoardService;
import com.school.service.FileService;
import com.school.util.MD5Generator;
import com.school.view.BoardDownloadView;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {

	private final int PAGE_SIZE = 15; 	// 한 페이지에 표시되는 데이터 개수
	private final int PAGER_SIZE = 5;	// 한 번에 표시할 페이지 번호 개수
	private final String LINK_URL = "list"; // 페이지 번호를 클릭했을 때 이동할 페이지 경로
	
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
	public String write(@RequestParam(defaultValue = "-1") int boardType, @RequestParam("file") MultipartFile file, BoardDto board, Model model) {
		
		if (boardType == -1) {
			return "redirect:/home";
//			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
		}
		
		// 첨부파일
		try {
			if (file.getOriginalFilename().length() != 0) {
				String userFileName = file.getOriginalFilename();
				String filename = (Util.makeUniqueFileName(userFileName)).replaceAll("[-]","");
				/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
	            String savePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\resources\\img\\board";
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
	            board.setFileNo(fileNo);
			}
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
	public String showDetail(@RequestParam(defaultValue = "-1") int boardType, @RequestParam(defaultValue = "-1") int boardNo, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		if (boardType == -1 || boardNo == -1) {
			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
			return "redirect:/home";
		}
		
		// 조회수 증가 (쿠키)
		boardService.updateReadCount(boardNo, request, response);
		
		BoardDto board = boardService.findByBoardNo(boardNo);
		FileDto file = fileService.getFile(board.getFileNo());
		
		model.addAttribute("board", board);
		model.addAttribute("boardType", boardType);
		model.addAttribute("file", file);
		
		return "/board/detail";
	}
	
	// 게시글 상세 조회 - 첨부파일 미리보기 (1)
//	@GetMapping(path = { "/showImage" })
//	@ResponseBody
//	public ResponseEntity<byte[]> showImage(String fileName, String filePath) {
//		
//		File file = new File(filePath, fileName);
//		ResponseEntity<byte[]> result = null;
//		try {
//			HttpHeaders headers = new HttpHeaders();
//			headers.add("Content-Type", Files.probeContentType(file.toPath()));
//			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
	
	// 첨부파일 다운로드 (1) - 구글링 - 미완성
//	@GetMapping(path = { "/download/{fileNo}" })
//	public ResponseEntity<Resource> fileDownload(@PathVariable("fileNo") Long fileNo) throws IOException {
//
//		FileDto file = fileService.getFile(fileNo);
//	    Path path = Paths.get(file.getFilePath());
//	    Resource resource = new InputStreamResource(Files.newInputStream(path));
//	    return ResponseEntity.ok()
//	            .contentType(MediaType.parseMediaType("application/octet-stream"))
//	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getUserFileName() + "\"")
//	            .body(resource);
//			
//	}
	
	// 첨부파일 다운로드 (2) - 학원에서 배운 방식 - 완성
	@GetMapping(path = { "/download" })
	public View download(@RequestParam(defaultValue = "-1") Long fileNo, Model model) {
		
		if (fileNo == -1) {
			model.addAttribute("error_type", "download");
//			model.addAttribute("message", "첨부파일 번호가 없습니다");
		}
		
		FileDto file = fileService.getFile(fileNo);

		model.addAttribute("file", file);
		
		BoardDownloadView view = new BoardDownloadView(); 
		
		return view;
	}
	
	// 게시글 수정 폼
	@GetMapping(path = { "/modify" })
	public String showModify(@RequestParam(defaultValue = "-1") int boardType, @RequestParam(defaultValue = "-1") int boardNo, Model model) {
		
		if (boardType == -1 || boardNo == -1) {
			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
			return "redirect:/home";
		}
		
		BoardDto board = boardService.findByBoardNo(boardNo);
		FileDto file = fileService.getFile(board.getFileNo());
		
		model.addAttribute("board", board);
		model.addAttribute("boardType", boardType);
		model.addAttribute("file", file);
		
		return "/board/modify";
	}
	
	// 게시글 수정
	@PostMapping(path = { "/modify" })
	public String modify(@RequestParam(defaultValue = "-1") int boardType, Long prevFileNo, BoardDto board, @RequestParam("file") MultipartFile file) {
		
		if (boardType == -1) {
			return "redirect:/home";
//			model.addAttribute("error_type", "writeForm");
//			model.addAttribute("message", "잘못된 요청 : 글 번호 또는 페이지 번호가 없습니다.");
//			return "/board/error";
		}
		
		if(file != null) { // 첨부파일이 존재하는 경우
			try {
				if (file.getOriginalFilename().length() != 0) { // 첨부파일 수정 있을 경우
					String userFileName = file.getOriginalFilename();
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
		            file.transferTo(new File(filePath));
		
		            FileDto fileDto = new FileDto();
		            fileDto.setUserFileName(userFileName);
		            fileDto.setSavedFileName(filename);
		            fileDto.setFilePath(filePath);

		            fileService.deleteFile(prevFileNo);
		            Long fileNo = fileService.saveFile(fileDto);
		            board.setFileNo(fileNo);
		            boardService.modifyBoard(board);
				} else { // 게시글은 변경했지만 첨부파일은 수정하지 않은 경우
					board.setFileNo(prevFileNo);
					boardService.modifyBoard(board);
				}
			} catch (Exception e){
				e.printStackTrace();
			}
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
