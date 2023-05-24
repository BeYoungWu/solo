package com.school.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

	// 문의 접수 완료
	@Modifying
	@Transactional
	@Query("UPDATE tbl_contact c SET c.checked = 1 WHERE c.contactNo = :contactNo")
	void contactCheck(@Param("contactNo") int contactNo);

	
}
