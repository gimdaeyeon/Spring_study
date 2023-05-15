package com.example.ex02.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberDto {
    private String name;
    private int age;
    private String id;
    private String password;
    private String gender;

}
