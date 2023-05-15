package com.example.ex01.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor //기본생성자 어노테이션
public class MemberDto {
    private Long memberNumber;
    private String memberName;
    private Integer memberAge;

}
