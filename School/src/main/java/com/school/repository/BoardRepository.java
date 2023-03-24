package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.BoardEntity;


public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

	
}
