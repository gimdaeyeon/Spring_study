package com.example.ex02.controller;

import com.example.ex02.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//Spring 컨테이너에 Bean등록을 하기 위한 어노테이션
//목적이 컨트롤러임을 알려준다. 그래야 Handler Mapping이 찾아낼 수 있다.
@Controller
@Slf4j
//특정 url로 요청이 들어왔을 때 어떤 컨트롤러와 매핑되는지 알려주는 어노테이션
//JSP에서 web.xml에 설정했던 내용을 컨트롤러에서 어노테이션으로 쉽게 해줄 수있다.
@RequestMapping("/ex/*") // '/ex/' 로 시작하는 url을 전부 이 컨트롤러로 매핑해준다.
public class ExampleController {
//    어노테이션(속성)안에 값이 1개면 자동으로 value속성으로 된다(생략가능)
//    @RequestMapping(value = "/01", method = {RequestMethod.GET,RequestMethod.POST})
//    './ex/' 라는 상위 경로로 요청이 들어오면 이 컨트롤러가 실행된다.
//    그 중 어떤 메소드를 실행시킬지를 정해주려면 하위 경로도 등록을 해야한다.
    @GetMapping("01")
    public String ex01(MemberDto member){ // 반환타입이 String일 경우 forward방식으로 페이지를 전환한다.
        log.info("ex01()실행!!!!!!");
        log.info("이름은 : "+member.getName());
        log.info("나이는 : "+ (member.getAge()+3));

//        반환타입이 String이면 html경로를 작성하면된다.
//        해당 파일로 포워드방식으로 화면이동을 해준다.

        return "ex/03"; //html파일의 경로이다.
    }

    @GetMapping("/02")
    public void ex02(MemberDto member){ //반환타입이 void인 경우 url경로와 동일한 html을 foward방식으로 찾아간다.
                                    // /ex/02 <-- templates/ex/02.html 을 찾아간다.
        log.info("ex02()실행!!!!!!");
        log.info("gender : " + member.getGender());
        log.info("id : " + member.getId());
        log.info("password : " + member.getPassword());
    }

    @GetMapping
    public void ex03(HttpServletRequest req){

        log.info("ex03()실행!!!!!!");
        log.info(req.getParameter("name"));
     }

     @GetMapping("/04")// 화면에서 보내는 데이터의 name과 매개변수의 이름이 불일치한다면
                            //자동으로 매칭되지 않기 때문에 RequestParam어노테이션으로 직접 매핑해준다.
    public void ex04(@RequestParam("id") String name, int age){
        log.info("***************");
        log.info("name : " +name);
        log.info("age : " +age);
        log.info("***************");
     }

     @GetMapping("/05") //개발자가 직접 만든 타입은 매개변수에 선언을 하면 html에서 앞글자만 소문자로 바꾸어 사용이 가능하다
                            //그러나 개발자가 만들지 않은 기본제공 타입들은 Model객체에 저장하고 사용해야한다.
                            //Model 객체에 저장된 데이터는 자동으로 request객체에도 저장된다.
                            //모델 객체에 데이터를 저장하는 방법중 하나가 @ModelAttribute()를 사용하는 것이다.
                        //@ModelAttribute("member") MemberDto memberDto
                        // -> 이렇게도 가능(보통 th문에서 사용하는 이름바꾸고 싶을 때 쓴다.)
                        //th문에서 객체를 가져올때는 변수명이 아닌 타입의 이름으로 가져오고
                        // 맨 앞글자는 소문자로 변경하여 가져온다. ex) MemberDto memberDto -> memberDto.name;
    public String ex05(MemberDto memberDto, @ModelAttribute("id2") String id2){
        memberDto.setName(id2);
         log.info("***************");
         log.info("name : " +memberDto.getName());
         log.info("age : " +memberDto.getAge());
         log.info("***************");
         return "ex/03";
     }

    @GetMapping("06")
    public void ex06(String name2, int age2, String gender2, Model model){
        model.addAttribute("name", name2);
        model.addAttribute("age", age2);
        model.addAttribute("gender", gender2);
    }

    @GetMapping("/07")  //체크박스 등 같은 이름으로 여러 값을 보내게 된다면
                            //List를 활용하여 한 번에 받을 수 있다.
                            // 단,@RequestParam을 반드시 사용해야한다.
    public void ex07(@RequestParam("color") List<String> color){
        log.info(color.toString());
    }

    @GetMapping("/last")
    public void last(String in, Model model){
        model.addAttribute("in", in);
    }
    @GetMapping("/last2")
    public void last2(){}

    @PostMapping("/last2")
    public String last2(String in, Model model){
        model.addAttribute("in", in);

        return "ex/last2";
    }








}
