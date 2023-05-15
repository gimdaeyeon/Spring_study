package com.example.ex02.controller;

import com.example.ex02.dto.MemberDto;
import com.example.ex02.mapper.MemberMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/ex/*")
public class StudyExampleController {

    private MemberDto memberDto;
    private MemberMapper memberMapper;

    @Autowired
    public StudyExampleController(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @GetMapping("/01")
    public String ex01(MemberDto member){
        member.setMemberName(member.getMemberName());
        member.setMemberAge(member.getMemberAge());
        memberMapper.memberJoin(member);

        return "redirect:/";
    }

    @GetMapping("/02")
    public String ex02(String memberNumber, Model model){
        log.info(memberNumber);

        MemberDto memberDto = memberMapper.getMemberInfo(Integer.parseInt(memberNumber));

        if(memberDto==null){
            boolean isNull = true;
            model.addAttribute("isNull", isNull);
            return "index";
        }

        model.addAttribute("memberDto",memberDto);
        log.info(memberDto.toString());

        return "ex/result";
    }


}
