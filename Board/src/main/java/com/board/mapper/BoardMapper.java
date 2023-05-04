package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.board.domain.Board;

public interface BoardMapper {

	@Insert("INSERT INTO board (title, content) VALUES (#{title}, #{content})")
	void newBoard(Board board);
	
	@Select("SELECT * FROM board")
	List<Board> list();
	
	@Select("SELECT * FROM board WHERE id = #{id}")
	Board boardById(int id);
}
