package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

	// 선생님 파일 전체 불러오기
	@Query(value = "SELECT * FROM tbl_file f WHERE f.file_type = 1",
		   nativeQuery = true)
	List<FileEntity> findTeacherFiles();
	
	
}
