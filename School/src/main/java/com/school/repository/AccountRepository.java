package com.school.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

	// 중복아이디 체크
	AccountEntity findByUserId(String userId);
	
	// 로그인
	AccountEntity findByUserIdAndPasswd(String userId, String passwd);

	// 회원 신청 관리
	@Modifying
	@Transactional
	@Query("UPDATE tbl_account a SET a.userType = :wantType WHERE a.userId = :userId")
	void adminUserType(@Param("userId") String userId, @Param("wantType") int wantType);

	
}
