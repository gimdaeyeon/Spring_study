package com.example.test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
@Getter
public class Student {
    private final Study study;

    @Autowired
    public Student(@Qualifier("english") Study study) {
        this.study = study;
    }
}
