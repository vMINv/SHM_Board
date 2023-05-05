package com.board.service;

import java.util.List;

import com.board.domain.Board;

public interface BoardService {
	
	void newBoard(Board board);
	
	List<Board> list();
	
	Board boardById(int id);

	List<Board> sublist(int id);
}
