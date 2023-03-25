package com.school.service;

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


	
	
	
}
