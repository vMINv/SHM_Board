package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.Board;
import com.board.service.BoardService;

@Controller
@RequestMapping("boards")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/newBoard")
	public String formAddBoard(@ModelAttribute("NewBoard") Board board) {
		return "boards/add";
	}
	
	@PostMapping("/newBoard")
	public String SubmitAddBoard(@ModelAttribute("NewBoard") Board board) {
		boardService.newBoard(board);
		return "redirect:/boards/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		List<Board> list = boardService.list();
	    model.addAttribute("list", list);
	}
	
	@GetMapping("/board")
	public void boardById(@RequestParam("id") int id, Model model) {
		Board boardById = boardService.boardById(id);
		model.addAttribute("board", boardById);
	}
}
