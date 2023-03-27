package com.school.service;

import java.util.ArrayList;
import java.util.List;

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

		// 아직 첨부파일 안 넣음
		BoardEntity boardEntity = boardDtoToEntity(board);
		boardRepository.save(boardEntity);
		
	}

	// 게시글 목록 조회
	@Override
	public List<BoardDto> findByBoardType(int i) {
		
		List<BoardEntity> boardsEntity = boardRepository.findByBoardType(i);
		ArrayList<BoardDto> boards = new ArrayList<>();
		for (BoardEntity boardEntity : boardsEntity) {
			boards.add(boardEntityToDto(boardEntity));
		}
		
		return boards;
		
	}

	// 게시글 상세 조회
	@Override
	public BoardDto findByBoardNo(int boardNo) {
		
		BoardEntity boardEntity = boardRepository.findById(boardNo).orElse(null);
		BoardDto board = boardEntityToDto(boardEntity);
		
		return board;
	}
	
	
	
	
}
