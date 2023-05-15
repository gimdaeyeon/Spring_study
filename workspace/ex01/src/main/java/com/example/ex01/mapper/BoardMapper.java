package com.example.ex01.mapper;

import com.example.ex01.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insert(BoardDto boardDto);
    List<BoardDto> selectAll();
    BoardDto select(Long boardNumber);
    void update(BoardDto boardDto);
    void delete(Long boardNumber);
}
