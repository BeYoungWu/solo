package com.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "tbl_file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_file")
public class FileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fileNo;
	
	@Column(nullable = false)
	private String userFileName;
	
	@Column(nullable = false)
	private String savedFileName;
	
	@Column
	private int fileType;
	
	@Column(nullable = false)
	private String filePath;

//	@OneToOne
//	@JoinColumn(name = "fileNo")
//	private TeacherEntity teacher;
	
	@Builder
	public FileEntity(Long fileNo, String userFileName, String savedFileName, int fileType, String filePath) {
		this.fileNo = fileNo;
		this.userFileName = userFileName;
		this.savedFileName = savedFileName;
		this.fileType = fileType;
		this.filePath = filePath;
	}
	
}
