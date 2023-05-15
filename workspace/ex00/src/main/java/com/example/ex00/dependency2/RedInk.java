package com.example.ex00.dependency2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Qualifier("redInk")
public class RedInk implements Ink{
    public void myColor(){
        log.info("=====Red====");

    }
}
