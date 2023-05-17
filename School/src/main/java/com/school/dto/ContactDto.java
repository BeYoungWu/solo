package com.school.dto;

import lombok.Data;

@Data
public class ContactDto {
	
	private int contactId;
	private String name;
	private String email;
	private String title;
	private String content;
	
}
