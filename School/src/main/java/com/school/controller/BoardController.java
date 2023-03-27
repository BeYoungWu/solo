package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.dto.BoardDto;
import com.school.service.BoardService;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	// 게시글 등록 폼
	@GetMapping(path = { "/write" })
	public String showWriteForm(@RequestParam(defaultValue = "-1") int boardType, Model model) {

		model.addAttribute("boardType", boardType);
		
		return "/board/write";
	}
	
	// 게시글 등록
	@PostMapping(path = { "/write" })
	public String write(@RequestParam(defaultValue = "-1") int boardType, BoardDto board, Model model) {
		
		boardService.insertBoard(board);
		
//		model.addAttribute(model)
		
		return "/board/list";
	}
	
	// 게시글 목록 조회
	@GetMapping(path = { "/list" })
	public String showList(@RequestParam(defaultValue = "-1") int boardType, Model model) {
		
		// RequestParam pageNo 해야함
		
		List<BoardDto> boards = boardService.findByBoardType(boardType);
		
		model.addAttribute("boards", boards);
		model.addAttribute("boardType", boardType);
		
		return "/board/list";
	}
	
	// 게시글 상세 조회
	@GetMapping(path = { "/detail" })
	public String showDetail(@RequestParam(defaultValue = "-1") int boardType, @RequestParam(defaultValue = "-1") int boardNo, Model model) {
		
		BoardDto board = boardService.findByBoardNo(boardNo);
		
		model.addAttribute("board", board);
		model.addAttribute("boardType", boardType);
		
		return "/board/detail";
	}
	
	
}
