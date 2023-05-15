package com.example.ex03.service;

import com.example.ex03.dto.MemberDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MemberService {
//    추가
    public void addMember(MemberDto memberDto);
//    번호 조회
    public Optional<Long> findNumber(MemberDto memberDto);
}
