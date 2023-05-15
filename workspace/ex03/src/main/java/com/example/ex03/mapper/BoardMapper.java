package com.example.ex03.mapper;

import com.example.ex03.dto.BoardDto;
import com.example.ex03.dto.MemberDto;
import com.example.ex03.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
    public List<BoardDto> select(SearchVo searchVo);
}
