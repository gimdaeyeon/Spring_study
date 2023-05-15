package com.example.ex01.mapper;

import com.example.ex01.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void insert() {
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberAge(22);
        memberDto.setMemberName("홍길동");

        memberMapper.insert(memberDto);
    }

    @Test
    void update(){
        MemberDto memberDto = new MemberDto();

        memberDto.setMemberNumber(1L);
        memberDto.setMemberName("김대연");

        memberMapper.update(memberDto);
    }

    @Test
    void select(){
        MemberDto memberDto = memberMapper.select(1);
        log.info("******"+memberDto.toString());
    }

    @Test
    void delete(){
        memberMapper.delete(1L);
    }


}