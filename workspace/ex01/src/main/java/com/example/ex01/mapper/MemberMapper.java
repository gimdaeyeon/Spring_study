package com.example.ex01.mapper;

import com.example.ex01.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void insert(MemberDto memberDto);

    void update(MemberDto memberDto);

    MemberDto select(int memberNumber);

    void delete(Long memberNumber);
}
