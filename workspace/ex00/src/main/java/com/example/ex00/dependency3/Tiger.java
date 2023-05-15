package com.example.ex00.dependency3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Qualifier("tiger") @Primary
public class Tiger implements Animal{

    @Override
    public void crying() {
        log.info("*****으르러어어어엉!!!*****");
    }
}
