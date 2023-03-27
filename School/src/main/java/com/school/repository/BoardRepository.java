package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.BoardEntity;


public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

	List<BoardEntity> findByBoardType(int i);

	
}
