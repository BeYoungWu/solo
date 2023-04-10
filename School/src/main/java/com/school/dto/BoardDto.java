package com.school.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDto {
	
	private int boardNo;
	private int boardType;
	private String title;
	private String writer;
	private String content;
	private Date writeDate;
	private int readCount;
	
	private long fileNo;
	
}
