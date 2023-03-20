package com.school.dto;

import lombok.Data;

@Data
public class AccountDto {
	
	private String userId;
	private String passwd;
	private int wantType;
	private int userType;
	private int postCode;
	private String address1;
	private String address2;
	private String address3;
	private String phone1;
	private String phone2;
	private String phone3;
	
}
