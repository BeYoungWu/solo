package com.school.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

	// 교직원 수정
	@Modifying
	@Transactional
	@Query("UPDATE tbl_teacher t SET t.fileNo=:#{#te.fileNo}, t.subject=:#{#te.subject}, t.teacherName=:#{#te.teacherName} WHERE t.teacherNo=:#{#te.teacherNo}")
	void modifyTeacher(@Param("te") TeacherEntity te);

	
}
