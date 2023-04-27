package com.school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Entity(name = "tbl_teacher")
@Table(name = "tbl_teacher")
public class TeacherEntity {
	
	public TeacherEntity(TeacherDto teacher) {
		this.teacherNo = teacher.getTeacherNo();
		this.teacherName = teacher.getTeacherName();
		this.subject = teacher.getSubject();
		this.fileNo = teacher.getFileNo();
	}
	
	public TeacherDto exportTeacherDto() {
		TeacherDto teacher = new TeacherDto();
		teacher.setTeacherNo(teacherNo);
		teacher.setTeacherName(teacherName);
		teacher.setSubject(subject);
		teacher.setFileNo(fileNo);
		
		return teacher;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teacherNo;
	
	@Column(nullable = false)
	private String teacherName;
	
	@Column
	private String subject;
	
	@Column
	private Long fileNo;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private FileEntity file;
	
	
	
}
