## Spring MVC
![SpringMvc](../resource/SpringMVC.png)

## 스프링 MVC

- 스프링 MVC에서는 Dispatcher servlet이 Front Controller의 역할을한다.
  
- Controller의 메소드를 Handler라고도 부른다.

1. Dispatcher 서블릿이 요청을 받으면 Handler Mapping 을 통해서 URL에 매칭된 컨트롤러를 찾는다.
2. 디스패쳐 서블릿이 핸들러 어댑터를 실행시킨다.
3. 핸들러 어댑터가 올바른 핸들러를 실행시키고 핸들러는 결과를 반환한다.
4. 핸들러 어댑터가 받은 결과를 ModelAndView객체로 변환하여 디스패쳐 서블릿에게 전달한다.
   
    **ModelAndView객체는 다음과 같은 정보를 담고있다**
    - Model : 컨트롤러에서 처리한 데이터를 저장(DB에서 가져온 정보 등)
    - View : 클라이언트에게 보여줄 페이지의 이름을 저장 

5. 디스패쳐 서블릿이 받은 결과 중 어떤 view가 필요한지를 뷰 리졸버에 전달한다.
6. 뷰 리졸버는 올바른 View를 찾아 디스패쳐 서블릿에게 경로를 알려준다.
7. View는 디스패쳐 서블릿에게 받은 모델 데이터로 html을 완성시켜 클라이언트에게 응답을 보내다.

### 특징
- HttpServletRequest, HttpServletResponse 를 거의 사용할 필요 없이 구현 가능하다.
- 다양한타입의 파라미터, 다양한 타입의 리턴 사용이 가능하다.
- GET, POST 등의 전송 방식에 대한 처리를 어노테이션으로 처리가 가능하다.





