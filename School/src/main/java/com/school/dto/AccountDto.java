package com.school.dto;

import lombok.Data;

@Data
public class AccountDto {
	
	private String userId;
	private String passwd;
	private String userName;
	private int wantType;
	private int userType;
	private String postCode;
	private String address;
	private String phone1;
	private String phone2;
	private String phone3;
	
}
