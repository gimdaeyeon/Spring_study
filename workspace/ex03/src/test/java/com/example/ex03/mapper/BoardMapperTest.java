package com.example.ex03.mapper;

import com.example.ex03.vo.SearchVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    void select() {
        SearchVo searchVo = new SearchVo();
        searchVo.setSearchType("memberId");
        searchVo.setKeyword("1234");

        boardMapper.select(searchVo).stream().forEach(board -> log.info(board.toString()));

    }
}