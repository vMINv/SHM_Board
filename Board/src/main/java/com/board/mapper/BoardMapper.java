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
	
	@Select("SELECT * \n" + 
			"FROM board\n" + 
			"WHERE id IN (SELECT id\n" + 
			"			FROM (SELECT id, word\n" + 
			"				FROM board, (SELECT word \n" + 
			"									FROM (SELECT COUNT(DISTINCT id) AS CNT, word\n" + 
			"											FROM board, (SELECT DISTINCT word\n" + 
			"																FROM (SELECT SUBSTRING_INDEX(SUBSTRING_INDEX(REGEXP_REPLACE(content, '[^[:alnum:][:space:]]+', ''),' ', n.n), ' ', -1) AS word\n" + 
			"																	  FROM board, (SELECT a.n + b.n * 10 + 1 AS n\n" + 
			"																						 FROM (SELECT 0 AS n UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS a\n" + 
			"																						 CROSS JOIN (SELECT 0 AS n UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS b\n" + 
			"																						)AS n \n" + 
			"																	  WHERE id = #{id} AND n.n <= 1 + (LENGTH(content) - LENGTH(REPLACE(content, ' ', '')))\n" + 
			"																	 )AS words\n" + 
			"															) AS word\n" + 
			"											WHERE id != #{id} AND INSTR(content, word) > 0\n" + 
			"											GROUP BY word) AS word\n" + 
			"									WHERE CNT <= (SELECT COUNT(*) FROM board)*0.4) AS word\n" + 
			"				WHERE id != #{id} AND INSTR(content, word) > 0\n" + 
			"				GROUP BY id, word) AS id\n" + 
			"			GROUP BY id\n" + 
			"			HAVING COUNT(*)>=2\n" + 
			"           ORDER BY COUNT(*) DESC)")
	List<Board> sublist(int id);
}
