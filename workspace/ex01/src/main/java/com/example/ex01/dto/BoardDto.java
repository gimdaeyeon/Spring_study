package com.example.ex01.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor //기본생성자 어노테이션
public class BoardDto {
    private Long boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
}
