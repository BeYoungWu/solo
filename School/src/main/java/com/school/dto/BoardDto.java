package com.school.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDto {
	
	private int boardNo;
	private int boardType;
	private String notice;
	private String title;
	private String writer;
	private String content;
	private Timestamp writeDate;
	private Timestamp modifyDate;
	private int readCount;
	
	private long fileNo;
	
}
