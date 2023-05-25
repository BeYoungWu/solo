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
//	@Query(value = "SELECT * FROM tbl_board b WHERE b.board_type = :boardType ORDER BY b.board_no DESC LIMIT :from, :count",
//		   nativeQuery = true)
//	List<BoardEntity> findByBoardType(@Param("boardType") int i, @Param("from") int from, @Param("count") int count);

	// 게시글 개수 조회
	@Query(value = "SELECT COUNT(b.board_no) FROM tbl_board b WHERE b.board_type = :boardType",
		   nativeQuery = true)
	Long countByBoardType(@Param("boardType") int boardType);
	
	// 조회수 증가
	@Modifying
	@Transactional
    @Query("UPDATE tbl_board b SET b.readCount = b.readCount + 1 WHERE b.boardNo = :boardNo")
    int updateReadCount(@Param("boardNo") int boardNo);

	// 게시글 수정
	@Modifying
	@Transactional
    @Query("UPDATE tbl_board b SET b.boardType=:#{#be.boardType}, b.title=:#{#be.title}, b.content=:#{#be.content}, b.fileNo=:#{#be.fileNo} WHERE b.boardNo = :#{#be.boardNo}")
	void modifyBoard(@Param("be") BoardEntity be);

	
	
}
