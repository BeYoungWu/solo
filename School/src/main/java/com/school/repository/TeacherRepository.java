package com.school.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.entity.TeacherEntity;


public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

	// 과목 목록 불러오기
	@Query(value = "SELECT DISTINCT t.subject FROM tbl_teacher t")
	List<String> findAllSubjects();

	// 교직원 목록 불러오기 + 각자의 사진 파일까지
	@Query(value = "SELECT t.teacher_no, t.teacher_name, t.subject, f.* FROM tbl_teacher t JOIN tbl_file f ON t.file_no = f.file_no",
		   nativeQuery = true)
	List<HashMap<String, Object>> findAllTeachersAndPic();

	
}
