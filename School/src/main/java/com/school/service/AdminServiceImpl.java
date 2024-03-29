package com.school.service;

import java.util.ArrayList;
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
	
	// 교직원 목록 불러오기
	@Override
//	public List<HashMap<String, Object>> findAllTeachers() {
	public List<TeacherDto> findAllTeachers() {
		
//		List<HashMap<String, Object>> teachers = teacherRepository.findAllTeachersAndPic();
		List<TeacherEntity> teachersEntity = teacherRepository.findAllTeachersAndPic();
		ArrayList<TeacherDto> teachers = new ArrayList<>();
		for (TeacherEntity teacherEntity : teachersEntity) {
			teachers.add(teacherEntityToDto(teacherEntity));
		}
		
		return teachers;
	}
	
	// 교직원 등록
	@Override
	public void insertTeacher(TeacherDto teacher) {

		TeacherEntity teacherEntity = teacherDtoToEntity(teacher);
		teacherRepository.save(teacherEntity);

	}
	
	// 교직원 정보 불러오기
	@Override
	public TeacherDto findTeacherByNo(int teacherNo) {

		TeacherEntity teacherEntity = teacherRepository.findById(teacherNo).orElse(null);
		TeacherDto teacher = teacherEntityToDto(teacherEntity);
		
		return teacher;
	}

	// 교직원 수정
	@Override
	public void modifyTeacher(TeacherDto teacher) {

		TeacherEntity te = teacherDtoToEntity(teacher);
		
		teacherRepository.modifyTeacher(te);
		
	}

	// 교직원 삭제
	@Override
	public void deleteTeacher(int teacherNo) {
		
		teacherRepository.deleteById(teacherNo);
		
	}

	
}
