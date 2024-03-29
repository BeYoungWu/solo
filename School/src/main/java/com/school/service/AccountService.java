package com.school.service;

import java.util.List;

import com.school.dto.AccountDto;
import com.school.entity.AccountEntity;

public interface AccountService {

	public default AccountDto accountEntityToDto(AccountEntity accountEntity) {
		
		AccountDto accountDto = new AccountDto();
		
		accountDto.setUserId(accountEntity.getUserId());
		accountDto.setPasswd(accountEntity.getPasswd());
		accountDto.setUserName(accountEntity.getUserName());
		accountDto.setWantType(accountEntity.getWantType());
		accountDto.setUserType(accountEntity.getUserType());
		accountDto.setPostCode(accountEntity.getPostCode());
		accountDto.setAddress(accountEntity.getAddress());
		accountDto.setPhone1((accountEntity.getPhone()).substring(0,3));
		accountDto.setPhone2((accountEntity.getPhone()).substring(3,7));
		accountDto.setPhone3((accountEntity.getPhone()).substring(7,11));
		
		return accountDto;
	}
	
	public default AccountEntity accountDtoToEntity(AccountDto accountDto) {
		
		AccountEntity accountEntity = AccountEntity.builder()
												   .userId(accountDto.getUserId())
												   .passwd(accountDto.getPasswd())
												   .userName(accountDto.getUserName())
												   .wantType(accountDto.getWantType())
												   .userType(accountDto.getUserType())
												   .postCode(accountDto.getPostCode())
												   .address(accountDto.getAddress())
												   .phone(accountDto.getPhone1() + accountDto.getPhone2() + accountDto.getPhone3())
												   .build();
		
		return accountEntity;
	}
	
	// 회원가입
	void register(AccountDto account);
	
	// 중복아이디 체크
	AccountDto checkId(String userId);
	
	// 로그인
	AccountDto findUserByIdAndPasswd(String userId, String passwd);

	// 모든 사용자 조회 (관리자)
	List<AccountDto> findAllUsers();

	// 모든 사용자 수 조회
	Long countAllUser();

	// 회원 신청 관리
	void adminUserType(String userId);

	// 아이디 찾기
	List<AccountDto> findUserId(AccountDto account);
	
}
