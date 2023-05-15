package com.example.ex02.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberDto {
    private Long memberNumber;
    private String memberName;
    private Long memberAge;

}
