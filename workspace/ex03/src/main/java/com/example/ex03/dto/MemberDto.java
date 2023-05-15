package com.example.ex03.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberDto {
    private Long memberNumber;
    private String memberId;
    private String memberPassword;
    private String memberName;
}
