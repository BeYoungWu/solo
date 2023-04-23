package com.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.school.dto.TeacherDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_teacher")
public class TeacherEntity {
	
	public TeacherEntity(TeacherDto teacher) {
		this.teacherNo = teacher.getTeacherNo();
		this.teacherName = teacher.getTeacherName();
		this.subjectNo = teacher.getSubjectNo();
		this.fileNo = teacher.getFileNo();
	}
	
	public TeacherDto exportTeacherDto() {
		TeacherDto teacher = new TeacherDto();
		teacher.setTeacherNo(teacherNo);
		teacher.setTeacherName(teacherName);
		teacher.setSubjectNo(subjectNo);
		teacher.setFileNo(fileNo);
		
		return teacher;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teacherNo;
	
	@Column(nullable = false)
	private String teacherName;
	
	@Column
	private int subjectNo;
	
	@Column
	private Long fileNo;
	
}
