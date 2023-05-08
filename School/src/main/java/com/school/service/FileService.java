package com.school.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.school.dto.FileDto;
import com.school.entity.FileEntity;
import com.school.repository.FileRepository;

@Service
public class FileService {

    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    // 파일 저장하기
    @Transactional
    public Long saveFile(FileDto file) {
        return fileRepository.save(file.toEntity()).getFileNo();
    }

    // 파일 불러오기
    @Transactional
    public FileDto getFile(Long fileNo) {
        FileEntity file = fileRepository.findById(fileNo).orElse(null);
        
        if (file != null) {
	        FileDto fileDto = FileDto.builder()
	                .fileNo(fileNo)
	                .userFileName(file.getUserFileName())
	                .savedFileName(file.getSavedFileName())
	                .fileType(file.getFileType())
	                .build();
	        
	        return fileDto;
        } else {
        	return null;
        }
    }
    
    // 교직원 파일 전체 불러오기
    @Transactional
    public List<FileDto> getTeacherFiles() {
    	List<FileEntity> filesEntity = fileRepository.findTeacherFiles();
    	List<FileDto> files = new ArrayList<>();
    	if (filesEntity != null) {
    		for (FileEntity fileEntity : filesEntity) {
    			FileDto file = FileDto.builder()
    								  .fileNo(fileEntity.getFileNo())
    								  .userFileName(fileEntity.getUserFileName())
    								  .savedFileName(fileEntity.getSavedFileName())
    								  .fileType(fileEntity.getFileType())
    								  .build();
    			files.add(file);
    		}
	        return files;
        } else {
        	return null;
        }
    }

    // File Type으로 파일 불러오기
	public FileDto getFileByFileType(int i) {

		FileEntity file = fileRepository.findFileByFileType(i);
		
		if (file != null) {
	        FileDto fileDto = FileDto.builder()
	                .fileNo(file.getFileNo())
	                .userFileName(file.getUserFileName())
	                .savedFileName(file.getSavedFileName())
	                .fileType(file.getFileType())
	                .build();
	        
	        return fileDto;
        } else {
        	return null;
        }
	}
	
}
