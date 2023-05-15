package com.example.ex03.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardDto {
    private Long boardNumber;
    private String boardTitle;
    private String boardContent;
    private String memberId;
}
