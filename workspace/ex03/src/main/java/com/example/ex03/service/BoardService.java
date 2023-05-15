package com.example.ex03.service;

import com.example.ex03.dto.BoardDto;
import com.example.ex03.dto.MemberDto;
import com.example.ex03.mapper.BoardMapper;
import com.example.ex03.mapper.MemberMapper;
import com.example.ex03.vo.SearchVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService{
    private final BoardMapper boardMapper;

    public List<BoardDto> searchBoard(SearchVo searchVo){
        return boardMapper.select(searchVo);
    }
}
