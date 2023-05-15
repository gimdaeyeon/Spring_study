package com.example.ex03.service;

import com.example.ex03.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@RequiredArgsConstructor
class MemberServiceImplTest {

    @Autowired
    private MemberServiceImpl memberService;
    private MemberDto memberDto;

    @BeforeEach
    void setUp(){
        memberDto = new MemberDto();
        memberDto.setMemberId("ddd");
        memberDto.setMemberPassword("3232");
        memberDto.setMemberName("아트록스");
    }


    @Test
    void addMember() {
        memberService.addMember(memberDto);
    }

    @Test
    void findNumber() {
        Optional<Long> number = memberService.findNumber(memberDto);

        log.info("---number---- : "+ number);
    }
}