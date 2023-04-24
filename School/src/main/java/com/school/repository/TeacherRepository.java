package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.entity.TeacherEntity;


public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

	// 과목 목록 불러오기
	@Query(value = "SELECT DISTINCT t.subject FROM tbl_teacher t")
	List<String> findAllSubjects();

	
}
