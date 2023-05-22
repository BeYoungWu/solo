package com.school.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ContactDto {
	
	private int contactNo;
	private String name;
	private String email;
	private String title;
	private String content;
	private Timestamp contactDate;
	
}
