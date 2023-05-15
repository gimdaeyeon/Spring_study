package com.example.ex00.dependency2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PrinterTest {
    @Autowired
    private Printer printer;

    @Test
    public void diTest(){
        printer.print();
    }

}