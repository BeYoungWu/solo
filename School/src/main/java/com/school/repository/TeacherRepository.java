package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.TeacherEntity;


public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

	
}
