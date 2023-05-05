package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.Board;
import com.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public void newBoard(Board board) {
		boardMapper.newBoard(board);
	}

	@Override
	public List<Board> list() {
		return boardMapper.list();
	}

	@Override
	public Board boardById(int id) {
		return boardMapper.boardById(id);
	}

	@Override
	public List<Board> sublist(int id) {
		return boardMapper.sublist(id);
	}

}
