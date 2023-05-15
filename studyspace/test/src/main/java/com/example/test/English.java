package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Qualifier("english")
public class English implements Study{

    @Override
    public void study() {
        log.info("영어공부abc");
    }
}
