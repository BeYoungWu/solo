package com.school.service;

import com.school.dto.BoardDto;
import com.school.entity.BoardEntity;

public interface BoardService {

	public default BoardDto boardEntityToDto(BoardEntity boardEntity) {
		
		BoardDto boardDto = new BoardDto();
		
		boardDto.setBoardNo(boardEntity.getBoardNo());
		
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
	
	

	

	
}
