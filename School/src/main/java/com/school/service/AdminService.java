package com.school.service;

import java.util.HashMap;
import java.util.List;

import com.school.dto.TeacherDto;
import com.school.entity.TeacherEntity;

public interface AdminService {

	public default TeacherDto teacherEntityToDto(TeacherEntity teacherEntity) {
		
		TeacherDto teacherDto = new TeacherDto();
		
		teacherDto.setTeacherNo(teacherEntity.getTeacherNo());
		teacherDto.setTeacherName(teacherEntity.getTeacherName());
		teacherDto.setSubject(teacherEntity.getSubject());
		teacherDto.setFileNo(teacherEntity.getFileNo());
		
		return teacherDto;
	}
	
	public default TeacherEntity teacherDtoToEntity(TeacherDto teacherDto) {
		
		TeacherEntity teacherEntity = TeacherEntity.builder()
											 .teacherNo(teacherDto.getTeacherNo())
											 .teacherName(teacherDto.getTeacherName())
											 .subject(teacherDto.getSubject())
											 .fileNo(teacherDto.getFileNo())
											 .build();
		
		return teacherEntity;
	}

	// 과목 목록 불러오기
	List<String> findAllSubjects();
	
	// 교직원 목록 불러오기 + 각자의 사진 파일까지
	List<HashMap<String, Object>> findAllTeachers();
	
	// 교직원 등록
	void insertTeacher(TeacherDto teacher);
	


}
