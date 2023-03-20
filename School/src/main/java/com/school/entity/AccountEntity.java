package com.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.school.dto.AccountDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_account")
public class AccountEntity {
	
	public AccountEntity(AccountDto account) {
		this.userId = account.getUserId();
		this.passwd = account.getPasswd();
		this.wantType = account.getWantType();
		this.userType = account.getUserType();
		this.postCode = account.getPostCode();
		this.address = account.getAddress();
		this.phone = account.getPhone1() + account.getPhone2() + account.getPhone3();
	}
	
	public AccountDto exportAccountDto() {
		AccountDto account = new AccountDto();
		account.setUserId(userId);
		account.setPasswd(passwd);
		account.setWantType(wantType);
		account.setUserType(userType);
		account.setPostCode(postCode);
		account.setAddress(address);
		account.setPhone1(phone.substring(0,3));
		account.setPhone2(phone.substring(3,4));
		account.setPhone3(phone.substring(7,4));
		
		return account;
	}
	
	@Id
	private String userId;
	
	@Column(nullable = false)
	private String passwd;
	
	@Column(nullable = false)
	private int wantType;
	
	@Column(nullable = false)
	private int userType;
	
	@Column(nullable = false)
	private String postCode;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String phone;
	
}
