package com.study.board.controller;


import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLOutput;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping("/board/main")
    public String boardMainForm()
    {
        return "boardmain";
    }
    @GetMapping("/board/write")
    public String boardWriteForm()
    {
        return "boardwrite";
    }

    @GetMapping("/board/save")
    public String boardSaveForm(Board board)
    {
        boardService.write(board);
        return "";
    }
}
