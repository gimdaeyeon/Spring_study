package com.example.ex02.mapper;

import com.example.ex02.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void memberJoin(MemberDto member);
    MemberDto getMemberInfo(int memberNumber);
}
