package com.school.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.entity.BoardEntity;


public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

	// 게시글 목록 조회
	List<BoardEntity> findByBoardTypeOrderByBoardNoDesc(int i);

	// 게시판 수정
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE TBL_BOARD SET board_type=:#{ #be.boardType }, content=:#{ #be.content }, file_no=:#{ #be.fileNo }, title=:#{ #be.title } WHERE board_no=:#{ #be.boardNo }",
		   nativeQuery = true)
	void modifyBoard(@Param("be")BoardEntity be);
	
}
