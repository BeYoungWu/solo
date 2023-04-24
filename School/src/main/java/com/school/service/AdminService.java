package com.school.service;

import com.school.dto.TeacherDto;
import com.school.entity.TeacherEntity;

public interface AdminService {

	public default TeacherDto teacherEntityToDto(TeacherEntity teacherEntity) {
		
		TeacherDto teacherDto = new TeacherDto();
		
		teacherDto.setTeacherNo(teacherEntity.getTeacherNo());
		teacherDto.setTeacherName(teacherEntity.getTeacherName());
		teacherDto.setSubjectNo(teacherEntity.getSubjectNo());
		teacherDto.setFileNo(teacherEntity.getFileNo());
		
		return teacherDto;
	}
	
	public default TeacherEntity teacherDtoToEntity(TeacherDto teacherDto) {
		
		TeacherEntity teacherEntity = TeacherEntity.builder()
											 .teacherNo(teacherDto.getTeacherNo())
											 .teacherName(teacherDto.getTeacherName())
											 .subjectNo(teacherDto.getSubjectNo())
											 .fileNo(teacherDto.getFileNo())
											 .build();
		
		return teacherEntity;
	}


}
