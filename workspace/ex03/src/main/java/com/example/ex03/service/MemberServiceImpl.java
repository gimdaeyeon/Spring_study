package com.example.ex03.service;

import com.example.ex03.dto.MemberDto;
import com.example.ex03.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberMapper memberMapper;

    @Override
    public void addMember(MemberDto memberDto) {
        memberMapper.insert(memberDto);
    }

    @Override
    public Optional<Long> findNumber(MemberDto memberDto) {
        Optional<Long> memberNumber = Optional.ofNullable(memberMapper.selectNumber(memberDto));
        return memberNumber;
    }
}
