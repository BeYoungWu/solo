package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.school.common.Util;
import com.school.dto.AccountDto;
import com.school.entity.AccountEntity;
import com.school.repository.AccountRepository;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	@Qualifier("accountRepository")
	private AccountRepository accountRepository;

	// 회원가입
	
	
	// 로그인
	@Override
	public AccountDto findUserByIdAndPasswd(String userId, String passwd) {
		
		passwd = Util.getHashedString(passwd, "SHA-256");
		AccountEntity accountEntity = accountRepository.findByUserIdAndPasswd(userId, passwd);
		AccountDto accountDto = accountEntityToDto(accountEntity);
		
		return accountDto;
	}
	
	
}
