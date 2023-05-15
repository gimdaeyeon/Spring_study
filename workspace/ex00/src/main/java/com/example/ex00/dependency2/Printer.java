package com.example.ex00.dependency2;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class Printer {
    private final Ink Ink;

    @Autowired
    public Printer( Ink ink) {
        this.Ink = ink;
    }

    public void print(){
        Ink.myColor();
    }

}


