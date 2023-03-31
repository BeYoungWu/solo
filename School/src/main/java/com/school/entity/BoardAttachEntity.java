package com.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.school.dto.BoardAttachDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_board_attach")
public class BoardAttachEntity {
	
	public BoardAttachEntity(BoardAttachDto boardAttach) {
		this.attachNo = boardAttach.getAttachNo();
		this.userFileName = boardAttach.getUserFileName();
		this.savedFileName = boardAttach.getSavedFileName();
		this.filePath = boardAttach.getFilepath();
	}
	
	public BoardAttachDto exportBoardAttachDto() {
		BoardAttachDto boardAttach = new BoardAttachDto();
		boardAttach.setAttachNo(attachNo);
		boardAttach.setUserFileName(userFileName);
		boardAttach.setSavedFileName(savedFileName);
		boardAttach.setFilepath(filePath);
		
		return boardAttach;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int attachNo;
	
	@Column(length = 1000, nullable = false)
	private String userFileName;
	
	@Column(length = 1000, nullable = false)
	private String savedFileName;
	
	@Column(length = 1000, nullable = false)
	private String filePath;
}
