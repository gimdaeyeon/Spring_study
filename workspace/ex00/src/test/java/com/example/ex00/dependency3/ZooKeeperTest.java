package com.example.ex00.dependency3;

import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class ZooKeeperTest {
    @Autowired
    private ZooKeeper zooKeeper;
    @Test
    public void diTest2(){
        zooKeeper.getAnimal().crying();
    }


}