package com.example.ex02.controller;

import com.example.ex02.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class StudyExampleControllerTest {

    @Autowired
    private StudyExampleController studyExampleController;




    @Test
    void ex01() {
        MemberDto memberDto = new MemberDto();

        memberDto.setMemberName("강백호");
        memberDto.setMemberAge(18L);

        log.info(studyExampleController.ex01(memberDto));

    }
}