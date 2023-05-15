package com.example.ex03.optional;

import com.example.ex03.dto.MemberDto;
import com.example.ex03.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class OptionalTestStudy {

    @Autowired
    private MemberMapper memberMapper;
    private MemberDto memberDto;

    @BeforeEach
    public void setUp(){
        memberDto = new MemberDto();


    }

    @Test
    public void study01(){

        Optional<MemberDto> memberOpt = Optional.ofNullable(memberDto);

        try {
            memberOpt.orElseThrow(()-> {throw new IllegalArgumentException("잘못된 회원정보");}).getMemberNumber();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            log.info("해당 회원은 존재 하지 않습니다.");
        }catch(Exception e){
            e.printStackTrace();
        }

        log.info("정상 회원입니다.");
    }


}
