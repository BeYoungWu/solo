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

	// 조회수 증가
	@Modifying
	@Transactional
    @Query(value ="UPDATE tbl_board SET read_count = read_count + 1 WHERE board_no = :boardNo",
    	   nativeQuery = true)
    int updateReadCount(@Param(value = "boardNo") int boardNo);
	
}
