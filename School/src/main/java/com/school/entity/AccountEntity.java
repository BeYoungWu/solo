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
	}
	
	public AccountDto exportAccountDto() {
		AccountDto account = new AccountDto();
		account.setUserId(userId);
		account.setPasswd(passwd);
		account.setWantType(wantType);
		account.setUserType(userType);
		
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
	
}
