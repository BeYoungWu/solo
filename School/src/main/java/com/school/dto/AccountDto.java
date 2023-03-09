package com.school.dto;

import lombok.Data;

@Data
public class AccountDto {
	
	private String userId;
	private String passwd;
	private int wantType;
	private int userType;
	
}
