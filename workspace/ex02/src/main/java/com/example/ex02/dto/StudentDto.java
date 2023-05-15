package com.example.ex02.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentDto {
    private String name;
    private int math;
    private int eng;
    private int kor;
}
