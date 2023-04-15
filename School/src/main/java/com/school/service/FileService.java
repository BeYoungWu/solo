package com.school.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	                .filePath(file.getFilePath())
	                .build();
	        
	        return fileDto;
        } else {
        	return null;
        }
    }
	
}
