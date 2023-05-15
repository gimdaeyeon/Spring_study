package com.example.ex02.controller;

import com.example.ex02.dto.ProductDto;
import com.example.ex02.dto.StudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
이 컨트롤러의 url은 /task이다.
1. favorite.html에서 좋아하는 숫자와 색을 input으로 입력받는다. (컨트롤러에서 둘 다 String 으로 받기)\
    버튼을 누르면 favorite.html에 입력받은 데이터를 출력한다.
2. product.html 에서 상품명, 브랜드, 가격을 input으로 입력받고 버튼을 누르면 product.html화면에 입력받은 값을 출력한다.(dto사용하기)
3. StudentDto를 선언한다.
String name, int math, int eng, int kor
student.html에서 이름, 수학 점수, 영어 점수, 국어 점수를 입력받는다.
result.html에 입력받은 모든 값들을 출력하고 총점, 평균을 출력한다.
4. login.html에서 아이디와 비밀번호를 입력 받고 아이디가 admin이면 admin.html로 그 외에는 main.html로 이동한다.
 */
@Controller
@Slf4j
@RequestMapping("/task/*")
public class TaskController {
    @GetMapping("/favorite")
    public void favorite(){}

    @PostMapping("/favorite")
    public String favorite(String color, String number, Model model){
        model.addAttribute("color",color);
        model.addAttribute("number",number);
        return "task/favorite";
    }
    @GetMapping("/product")
    public void product(ProductDto productDto){}

    @PostMapping("/product")
    public String product(ProductDto productDto,Model model){
        return "task/product";
    }

    @GetMapping("/student")
    public void student(){}

    @PostMapping("/result")
    public String result(StudentDto studentDto, Model model){
        int total = studentDto.getEng()+studentDto.getKor()+studentDto.getMath();
        double avg = total/3;
        model.addAttribute("total", total);
        model.addAttribute("avg", avg);

        return "task/result";
    }

    @GetMapping("/login")
    public void login(){}

    @PostMapping("/login")
    public String login(String id, String password, Model model){
        model.addAttribute("id", id);
        model.addAttribute("password", password);
        if(id.equals("admin")){
            return "task/admin";
        }
        return "task/main";
    }


}
