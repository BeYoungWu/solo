package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

	
}
