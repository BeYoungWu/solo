package com.school.dto;

import com.school.entity.FileEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FileDto {
	
	private Long fileNo;
	private String userFileName;
	private String savedFileName;
	private int fileType;

	public FileEntity toEntity() {
		FileEntity build = FileEntity.builder()
						 .fileNo(fileNo)
						 .userFileName(userFileName)
						 .savedFileName(savedFileName)
						 .fileType(fileType)
						 .build();
		return build;
	}
	
	@Builder
	public FileDto(Long fileNo, String userFileName, String savedFileName, int fileType) {
		this.fileNo = fileNo;
		this.userFileName = userFileName;
		this.savedFileName = savedFileName;
		this.fileType = fileType;
	}
	
}
