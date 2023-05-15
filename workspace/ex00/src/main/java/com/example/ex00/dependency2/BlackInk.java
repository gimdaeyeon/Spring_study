package com.example.ex00.dependency2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Qualifier("blackInk") @Primary
public class BlackInk implements Ink{
    public void myColor(){
     log.info("******Black*****");

    }
}
