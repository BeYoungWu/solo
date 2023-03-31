package com.school.service;

import java.util.List;

import com.school.dto.BoardAttachDto;
import com.school.dto.BoardDto;
import com.school.entity.BoardAttachEntity;
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
											 .build();
		
		return boardEntity;
	}
	
	public default BoardAttachDto boardAttachEntityToDto(BoardAttachEntity boardAttachEntity) {
		
		BoardAttachDto boardAttachDto = new BoardAttachDto();
		
		boardAttachDto.setAttachNo(boardAttachEntity.getAttachNo());
		boardAttachDto.setUserFileName(boardAttachEntity.getUserFileName());
		boardAttachDto.setSavedFileName(boardAttachEntity.getSavedFileName());
		boardAttachDto.setFilepath(boardAttachEntity.getFilePath());
		
		return boardAttachDto;		
	}
	
	public default BoardAttachEntity boardAttachDtoToEntity(BoardAttachDto boardAttachDto) {
		
		BoardAttachEntity boardAttachEntity = BoardAttachEntity.builder()
															   .attachNo(boardAttachDto.getAttachNo())
															   .userFileName(boardAttachDto.getUserFileName())
															   .savedFileName(boardAttachDto.getSavedFileName())
															   .filePath(boardAttachDto.getFilepath())
															   .build();
		
		return boardAttachEntity;
	}

	// 게시글 등록
	public void insertBoard(BoardDto board);

	// 게시글 목록 조회
	public List<BoardDto> findByBoardType(int i);

	// 게시글 상세 조회
	public BoardDto findByBoardNo(int boardNo);

	// 게시글 수정
	public void modifyBoard(BoardDto board);

	// 게시글 삭제
	public void deleteBoard(int boardNo);
	
}
