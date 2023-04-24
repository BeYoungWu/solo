package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.school.dto.TeacherDto;
import com.school.entity.TeacherEntity;
import com.school.repository.TeacherRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	@Qualifier("teacherRepository")
	private TeacherRepository teacherRepository;
	
	// 과목 목록 불러오기
	@Override
	public List<String> findAllSubjects() {
		
		List<String> subjects = teacherRepository.findAllSubjects();
		
		return subjects;
	}
	
	// 교직원 등록
	@Override
	public void insertTeacher(TeacherDto teacher) {

		TeacherEntity teacherEntity = teacherDtoToEntity(teacher);
		teacherRepository.save(teacherEntity);
		
	}

	
	
	
	
}
