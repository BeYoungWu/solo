package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.school.repository.BoardRepository;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boardRepository")
	private BoardRepository boardRepository;


	
	
	
}
