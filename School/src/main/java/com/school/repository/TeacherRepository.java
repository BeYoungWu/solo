package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.entity.TeacherEntity;


public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

	// 과목 목록 불러오기
	@Query(value = "SELECT DISTINCT t.subject FROM tbl_teacher t")
	List<String> findAllSubjects();

	// 교직원 목록 불러오기 + 각자의 사진 파일까지
	@Query(value = "SELECT * FROM tbl_teacher t",
		   nativeQuery = true)
//	@Query(value = "SELECT t.teacherNo, t.teacherName, t.subject, f.fileNo, f.savedFileName, f.userFileName FROM tbl_teacher t, tbl_file f WHERE t.fileNo = f.fileNo")
//	List<HashMap<String, Object>> findAllTeachersAndPic();
	List<TeacherEntity> findAllTeachersAndPic();

	
}
