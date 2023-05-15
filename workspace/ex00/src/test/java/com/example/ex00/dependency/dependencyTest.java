package com.example.ex00.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 스프링 부트에서 지원하는 테스트용 어노테이션
// 테스트 클래스에 붙여주면 된다.
@Slf4j //logging 라이브러리
public class dependencyTest {
    @Autowired
    private Coding coding;

    @Test //특정 메소드만 실행시키고 싶을 때 사용하는 어노테이션
    public void DiTest(){
        System.out.println("coding : "+ coding);
        System.out.println("computer: "+ coding.getComputer());
    }

    @Test
    public void DiTest2(){
        log.info(coding.toString());
        log.info("computer :"+ coding.getComputer());
    }

}
