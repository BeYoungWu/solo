package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

	AccountEntity findByUserIdAndPasswd(String userId, String passwd);

	AccountEntity findByUserId(String userId);

	
}
