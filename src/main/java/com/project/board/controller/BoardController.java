package com.project.board.controller;

import com.project.board.entity.Board;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public String boardWriteForm(){
        return "boardWrite";
    }

    @PostMapping("")
    public String boardWritePro(Board board){
        boardService.write(board);
        return "redirect:/";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list", boardService.boardList());
        return "boardList";
    }

    @GetMapping("/board/view/{id}")
    public String boardView(@PathVariable("id") Long id, Model model){
        model.addAttribute("board", boardService.boardView(id));
        return "boardView";
    }


}
