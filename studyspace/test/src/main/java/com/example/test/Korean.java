package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Qualifier("korean") @Primary
public class Korean implements Study{

    @Override
    public void study() {
        log.info("국어공부 가나다라");
    }
}
