package com.school.service;

import com.school.dto.AccountDto;
import com.school.entity.AccountEntity;

public interface AccountService {

	public default AccountDto accountEntityToDto(AccountEntity accountEntity) {
		
		AccountDto accountDto = new AccountDto();
		
		accountDto.setUserId(accountEntity.getUserId());
		accountDto.setPasswd(accountEntity.getPasswd());
		accountDto.setWantType(accountEntity.getWantType());
		accountDto.setUserType(accountEntity.getUserType());
		
		return accountDto;
	}
	
	public default AccountEntity accountDtoToEntity(AccountDto accountDto) {
		
		AccountEntity accountEntity = AccountEntity.builder()
												   .userId(accountDto.getUserId())
												   .passwd(accountDto.getPasswd())
												   .wantType(accountDto.getWantType())
												   .userType(accountDto.getUserType())
												   .build();
		
		return accountEntity;
	}
	
	// 회원가입
	void register(AccountDto account);
	
	// 로그인
	AccountDto findUserByIdAndPasswd(String userId, String passwd);

	

	
}
