package com.school.service;

import java.util.ArrayList;
import java.util.List;

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
	@Override
	public void register(AccountDto account) {
		
		String passwd = Util.getHashedString(account.getPasswd(), "SHA-256");
		account.setPasswd(passwd); // 암호화된 패스워드를 account에 저장
		
		AccountEntity accountEntity = accountDtoToEntity(account);
		accountRepository.save(accountEntity);
		
	}
	
	// 중복아이디 체크
	@Override
	public AccountDto checkId(String userId) {
			
		AccountEntity accountEntity = accountRepository.findByUserId(userId);
		AccountDto account = new AccountDto();
		if (accountEntity != null) {
			account = accountEntityToDto(accountEntity);
		} else {
			account = null;
		}
		
		return account;
	}
	
	// 로그인
	@Override
	public AccountDto findUserByIdAndPasswd(String userId, String passwd) {
		
		passwd = Util.getHashedString(passwd, "SHA-256");
		
		AccountEntity accountEntity = accountRepository.findByUserIdAndPasswd(userId, passwd);
		
		AccountDto account = new AccountDto(); 
		
		if (accountEntity != null) {
			account = accountEntityToDto(accountEntity);
		} else {
			account = null;
		}

		return account;
	}

	// 모든 사용자 조회 (관리자)
	@Override
	public List<AccountDto> findAllUsers() {

		List<AccountEntity> aes = accountRepository.findAll();
		ArrayList<AccountDto> accounts = new ArrayList<>();
		for (AccountEntity ae : aes) {
			accounts.add(accountEntityToDto(ae));
		}
		
		return accounts;
	}

	

	
	
	
}
