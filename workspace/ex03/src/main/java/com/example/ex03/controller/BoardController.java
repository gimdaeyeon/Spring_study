package com.example.ex03.controller;

import com.example.ex03.dto.BoardDto;
import com.example.ex03.dto.MemberDto;
import com.example.ex03.service.BoardService;
import com.example.ex03.service.MemberService;
import com.example.ex03.vo.SearchVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/search")
    public void search(){}

    @PostMapping("/search")
    public void search(SearchVo searchVo, Model model){
        List<BoardDto> boardDtoList =boardService.searchBoard(searchVo);
        model.addAttribute("boardList", boardDtoList);

    }

}





