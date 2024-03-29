package com.school.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.dto.BoardDto;
import com.school.entity.BoardEntity;

public interface BoardService {

	public default BoardDto boardEntityToDto(BoardEntity boardEntity) {
		
		BoardDto boardDto = new BoardDto();
		
		boardDto.setBoardNo(boardEntity.getBoardNo());
		boardDto.setBoardType(boardEntity.getBoardType());
		boardDto.setNotice(boardEntity.getNotice());
		boardDto.setTitle(boardEntity.getTitle());
		boardDto.setWriterId(boardEntity.getWriterId());
		boardDto.setWriterName(boardEntity.getWriterName());
		boardDto.setContent(boardEntity.getContent());
		boardDto.setWriteDate(boardEntity.getWriteDate());
		boardDto.setModifyDate(boardEntity.getModifyDate());
		boardDto.setReadCount(boardEntity.getReadCount());
		boardDto.setFileNo(boardEntity.getFileNo());
		
		return boardDto;
	}
	
	public default BoardEntity boardDtoToEntity(BoardDto boardDto) {
		
		BoardEntity boardEntity = BoardEntity.builder()
											 .boardNo(boardDto.getBoardNo())
											 .boardType(boardDto.getBoardType())
											 .notice(boardDto.getNotice())
											 .title(boardDto.getTitle())
											 .writerId(boardDto.getWriterId())
											 .writerName(boardDto.getWriterName())
											 .content(boardDto.getContent())
											 .writeDate(boardDto.getWriteDate())
											 .modifyDate(boardDto.getModifyDate())
											 .readCount(boardDto.getReadCount())
											 .fileNo(boardDto.getFileNo())
											 .build();
		
		return boardEntity;
	}

	// 게시글 등록
	public void insertBoard(BoardDto board);

	// 게시글 목록 조회
	public List<BoardDto> findByBoardType(int i, int pageNo, int pageSize);
	
	// 게시글 개수 조회
	public Long countBoardByBoardType(int boardType);

	// 게시글 상세 조회
	public BoardDto findByBoardNo(int boardNo);

	// 조회수 증가
	public int updateReadCount(int boardNo, HttpServletRequest request, HttpServletResponse response);
	
	// 게시글 수정
	public void modifyBoard(BoardDto board);

	// 게시글 삭제
	public void deleteBoard(int boardNo);

	

}
