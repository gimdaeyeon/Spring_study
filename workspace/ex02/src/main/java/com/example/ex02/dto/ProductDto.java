package com.example.ex02.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductDto {
    private String name;
    private String brand;
    private Long price;
}
