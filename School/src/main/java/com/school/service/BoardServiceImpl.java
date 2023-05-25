package com.school.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.school.dto.BoardDto;
import com.school.entity.BoardEntity;
import com.school.repository.BoardRepository;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boardRepository")
	private BoardRepository boardRepository;

	// 게시글 등록
	@Override
	public void insertBoard(BoardDto board) {

		BoardEntity boardEntity = boardDtoToEntity(board);
		boardRepository.save(boardEntity);
		
	}

	// 게시글 목록 조회
	@Override
	public List<BoardDto> findByBoardType(int i, int pageNo, int pageSize) {
		
		int from = (pageNo -1) * pageSize;
		int count = pageSize;
		
		List<BoardEntity> boardsEntity = boardRepository.findByBoardType(i, from, count);
		ArrayList<BoardDto> boards = new ArrayList<>();
		for (BoardEntity boardEntity : boardsEntity) {
			boards.add(boardEntityToDto(boardEntity));
		}
		
		return boards;
		
	}
	
	// 게시글 개수 조회
	@Override
	public Long countBoardByBoardType(int boardType) {
		
		Long BoardCount = boardRepository.countByBoardType(boardType);
		
		return boardCount;
	}

	// 게시글 상세 조회
	@Override
	public BoardDto findByBoardNo(int boardNo) {
		
		BoardEntity boardEntity = boardRepository.findById(boardNo).orElse(null);
		BoardDto board = boardEntityToDto(boardEntity);
		
		return board;
	}
	
	private final static String VIEWCOOKIENAME = "alreadyViewCookie";
	
	// 조회수 증가
	@Override
	@Transactional
	public int updateReadCount(int boardNo, HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();
		boolean checkCookie = false;
		int result = 0;
		if(cookies != null) { // 이미 조회를 한 경우
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(VIEWCOOKIENAME + boardNo)) checkCookie = true;
			}
			if (!checkCookie) {
				Cookie newCookie = createCookieForNotOverlap(boardNo);
				response.addCookie(newCookie);
				result = boardRepository.updateReadCount(boardNo);
			}
			
		} else {
			Cookie newCookie = createCookieForNotOverlap(boardNo);
			response.addCookie(newCookie);
			result = boardRepository.updateReadCount(boardNo);
		}
		return result;
	}
	
	// 조회수 중복 방지를 위한 쿠키 생성 메소드
	private Cookie createCookieForNotOverlap(int boardNo) {
		Cookie cookie = new Cookie(VIEWCOOKIENAME + boardNo, String.valueOf(boardNo));
        cookie.setComment("조회수 중복 증가 방지 쿠키");	// 쿠키 용도 설명 기재
        cookie.setMaxAge(getRemainSecondForTommorow()); 	// 하루를 준다.
        cookie.setHttpOnly(true);				// 서버에서만 조작 가능
		
		return cookie;
	}
	
	// 다음날 정각까지 남은 시간(초)
	private int getRemainSecondForTommorow() {
		LocalDateTime now = LocalDateTime.now();
        LocalDateTime tommorow = LocalDateTime.now().plusDays(1L).truncatedTo(ChronoUnit.DAYS);
        return (int) now.until(tommorow, ChronoUnit.SECONDS);
	}
	
	// 게시글 수정
	@Override
	public void modifyBoard(BoardDto board) {
		
		BoardEntity be = boardDtoToEntity(board);
		
		boardRepository.modifyBoard(be);
		
	}

	// 게시글 삭제
	@Override
	public void deleteBoard(int boardNo) {

		boardRepository.deleteById(boardNo);
		
	}


	
	
	
	
}
