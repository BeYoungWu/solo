package com.school.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.school.dto.BoardDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_board")
public class BoardEntity {
	
	public BoardEntity(BoardDto board) {
		this.boardNo = board.getBoardNo();
		this.boardType = board.getBoardType();
		this.title = board.getTitle();
		this.writer = board.getWriter();
		this.content = board.getContent();
		this.writeDate = board.getWriteDate();
		this.readCount = board.getReadCount();
		this.fileNo = board.getFileNo();
	}
	
	public BoardDto exportBoardDto() {
		BoardDto board = new BoardDto();
		board.setBoardNo(boardNo);
		board.setBoardType(boardType);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setWriteDate(writeDate);
		board.setReadCount(readCount);
		board.setFileNo(fileNo);
		
		return board;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int boardNo;
	
	@Column(nullable = false)
	private int boardType;
	
	@Column(length = 34, nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String writer;
	
	@Column(length = 3000)
	private String content;

	@CreationTimestamp
	private Date writeDate;

	@Column
	@Builder.Default
	private int readCount = 0;
	
	@Column
	private Long fileNo;
	
}
