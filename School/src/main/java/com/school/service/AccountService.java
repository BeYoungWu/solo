package com.school.service;

import com.school.dto.AccountDto;

public interface AccountService {

	AccountDto findUserByIdAndPasswd(String userId, String passwd);

	
}
