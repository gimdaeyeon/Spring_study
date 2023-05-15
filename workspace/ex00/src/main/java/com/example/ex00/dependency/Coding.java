package com.example.ex00.dependency;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component// 해당 클래스 객체를 Bean으로 등록한다.
//Bean으로 등록된 객체는 스프링컨테이너가 자동으로 관리해준다.
//스프링컨테이너의 등록된 객체만 의존성 주입이 가능하다.
//@Data // Lombok에서 지원하는 어노테이션이다.
// getter, setter, equals, hashcode, toString을 한 번에 만들어준다.
@Getter @ToString
public class Coding {

//    @Autowired //의존성 주입에 사용하는 어노테이션(필드주입)
    private final Computer computer;

    @Autowired
    public Coding(Computer computer) {
        this.computer = computer;
    }
}

