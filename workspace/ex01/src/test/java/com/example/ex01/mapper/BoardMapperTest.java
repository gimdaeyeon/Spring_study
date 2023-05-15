package com.example.ex01.mapper;

import com.example.ex01.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;


    private BoardDto boardDto;

    @BeforeEach // 각 테스트 메소드를 실행시키기전에 이 메소드를 먼저 실행시킴
    void setUp(){
        boardDto = new BoardDto();
        boardDto.setBoardTitle("테스트 게시물이당");
        boardDto.setBoardContent("싱기");
        boardDto.setBoardWriter("불타는발바닥");

    }

    @Test
    void insert() {
        boardMapper.insert(boardDto);
    }

    @Test
    void selectAll(){
        List<BoardDto> boardList = boardMapper.selectAll();
        boardList.stream().forEach(list-> log.info(list.toString()));
        boardList.stream().map(BoardDto::toString).forEach(log::info);
    }
    @Test
    void select(){
        BoardDto boardDto = boardMapper.select(3L);
        log.info(boardDto.toString());
    }

    @Test
    void update(){
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardNumber(1L);
        boardDto.setBoardTitle("님들 ㅎㅇ");

        boardMapper.update(boardDto);
    }


    @Test
    void delete(){
        boardMapper.delete(2L);
    }




}