package com.school.service;

import java.util.List;

import com.school.dto.BoardDto;
import com.school.entity.BoardEntity;

public interface BoardService {

	public default BoardDto boardEntityToDto(BoardEntity boardEntity) {
		
		BoardDto boardDto = new BoardDto();
		
		boardDto.setBoardNo(boardEntity.getBoardNo());
		boardDto.setBoardType(boardEntity.getBoardType());
		boardDto.setTitle(boardEntity.getTitle());
		boardDto.setWriter(boardEntity.getWriter());
		boardDto.setContent(boardEntity.getContent());
		boardDto.setWriteDate(boardEntity.getWriteDate());
		boardDto.setReadCount(boardEntity.getReadCount());
		boardDto.setUserFileName(boardEntity.getUserFileName());
		boardDto.setSavedFileName(boardEntity.getSavedFileName());
		
		return boardDto;
	}
	
	public default BoardEntity boardDtoToEntity(BoardDto boardDto) {
		
		BoardEntity boardEntity = BoardEntity.builder()
											 .boardNo(boardDto.getBoardNo())
											 .boardType(boardDto.getBoardType())
											 .title(boardDto.getTitle())
											 .writer(boardDto.getWriter())
											 .content(boardDto.getContent())
											 .writeDate(boardDto.getWriteDate())
											 .readCount(boardDto.getReadCount())
											 .userFileName(boardDto.getUserFileName())
											 .savedFileName(boardDto.getSavedFileName())
											 .build();
		
		return boardEntity;
	}

	// 게시글 등록
	public void insertBoard(BoardDto board);

	// 게시글 목록 조회
	public List<BoardDto> findByBoardType(int i);

	// 게시글 상세 조회
	public BoardDto findByBoardNo(int boardNo);
	
	

	

	
}
