package com.example.ex03.optional;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class OptionalTest {

    @Test
    public void optional01(){
//        Optional<T>
//        옵셔널 클래스는 NPE방어를 위해 사용한다.

//        Optional객체 생성하기

        Optional<String> opt= Optional.empty();
//        비어있는 옵셔널 객체를 생성한다.
        Optional<String> opt2 = Optional.of("aa");
//        값을 저장하고 있는 옵셔널 객체를 생성한다.
//        값이 확실하게 null이 아닌 경우에만 사용한다.
//        만약에 null을 저장하면 NPE가 발생한다.
        Optional<String> opt3 = Optional.of(null);


        Optional<String> opt4 = Optional.ofNullable(null);
//        값을 저장하고 있는 옵셔널 객체를 생성한다.
//        값이 null일 수도 있는 경우 사용한다.

//        옵셔널 객체는 값을 저장할 수 있으며 저장한 값이 null인지 체크하거나, null이면 다른 값으로 대체해서
//        반환하는 등의 메소드를 지원한다.


    }

    @Test
    public void optional02(){
//        옵셔널 객체의 메소드
//        1. get()
//        옵셔널 객체에 저장된 값을 반환한다. null인경우 예외가 발생한다.(NoSuchElementException)
        Optional<String> opt = Optional.of("test");
        String result = opt.get();
        log.info("======="+result);

        Optional<String> opt2 = Optional.ofNullable(null);
//        String result2 = opt2.get();

//        2. orElse(대체 값)
//        옵셔널 객체에 저장된 값을 반환한다. 만약 null인 경우 [대체 값]이 반환된다.
        String result2 = opt2.orElse("null이다 짜식아!!");

        log.info("======="+result2);

        UserDto userDto = null;
//        userDto.getUserId(); => NPE
        Optional<UserDto> userOpt = Optional.ofNullable(userDto);

//        3. orElseGet(람다식)
//        옵셔널 객체에 저장된 값을 반환한다. 만약 null인 경우 [람다식을 실행한다.]
        userOpt.orElseGet( ()->new UserDto()).getUserId();
        userOpt.orElseGet(UserDto::new).getUserId();

//        4. orElseThrow(특정 예외)
//        옵셔널 객체에 저장된 값을 반환한다. 만약 null 인 경우 [특정 예외]가 발생한다.
        userOpt.orElseThrow(()->{throw new IllegalArgumentException("잘못된 회원 정보");}).getUserId();

//        5. isPresent()
//        옵셔널 객체에 저장된 값이 null이면 false, null이 아니면 true를 반환한다. (조건식으로 사용)

        if(userOpt.isPresent()){
            userOpt.get().getUserId();
        }



    }

}

class UserDto{
    Long userNumber;
    String userId;
    String userPassword;

    public Long getUserNumber() {
        return userNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }
}