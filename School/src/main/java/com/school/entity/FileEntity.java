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
@Entity
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
	
	@Column(nullable = false)
	private String filePath;

	@Builder
	public FileEntity(Long fileNo, String userFileName, String savedFileName, String filePath) {
		this.fileNo = fileNo;
		this.userFileName = userFileName;
		this.savedFileName = savedFileName;
		this.filePath = filePath;
	}
	
}
