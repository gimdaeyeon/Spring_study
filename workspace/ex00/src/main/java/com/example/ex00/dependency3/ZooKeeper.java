package com.example.ex00.dependency3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
Zookeeper(사육사), Sheep, Tiger, Animal을 활용하여의존관계를 맺고
모든 동물은 crying() 메소드를 갖도록 한다.
 */

@Component
@Getter
//@RequiredArgsConstructor
public class ZooKeeper {
    private final Animal animal;

    @Autowired
    public ZooKeeper(@Qualifier("sheep") Animal animal) {
        this.animal = animal;
    }


}
