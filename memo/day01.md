
## API (일반적으로 OpenAPI를 의미)
  어플리케이션 간 상호작용을 간단하게 해주는 인터페이스다.  
  다른 어플리케이션에서 제공하는 기능을 사용, 데이터 교환을 할 수 있으며 해당 기능을 사용할 때 내부 구현을 몰라도 사용할 수 있도록 도와준다.

## 라이브러리(도구)
재사용이 가능한 코드 모음이다.  
라이브러리에서 제공해주는 함수를 황용하면 개발자가 복잡한 알고리즘을 처음부터 구현할 필요가 없다.


## 프레임 워크
프레임워크는 특정 목적을 위해 만들어진 틀, 규칙이다.  
어플리케이션 개발을 위한 템플릿의 역할을 하며, 전체적인 구조와 패턴을 정의한다.  
같은 구조와 패턴을 사용하여 모든 개발자들이 표준화된 방식으로 개발을 할 수 있게 도와주고 개발 시간을 단축시켜준다.  

***라이브러리는 개발자에게 주도권이 있고 
프레임워크는 개발자에게 주도권이 없다.**

 ## Spring Boot 프레임 워크
 - 자바 기반 웹 어플리케이션 개발에 사용하는 프레임워크
 - 개발의 복잡성을 줄이고, 비교적 쉽게 테스트가 가능하여 생산성을 높인다.
 - 유지 관리에 용이하며, 다른 프레임 워크와 연동이 매우 뛰어나다.(접착성)

## 스프링 프레임워크의 주요 특징
1. POJO (Plain Old Java Object)기반<br> 순수 자바 객체를 사용하므로 기존 코드들을 재사용 가능하며, 테스트와 유지보수에 유리하다.
2. DI (Dependency Injection) : 의존성 주입 <br>  스프링의 핵심 기능이며, 클래스들 간 의존성을 낮춰주고 코드 재사용성을 높인다.
3. AOP (Aspect-Oriented Programming) 지원 : 관점 지향 프로그래밍 <br>
공통되고 반복되는 관심사(기능 등)를 분리하여 모듈화한다.  
관심사를 분리하면 개발자는 핵심 로직에만 집중하여 코드를 작성할 수 있으면 유지보수에 유리하다.
분리한 기능을 관점(Aspect)이라고 한다.
4. 트랜잭션 관리 <br>
  xml이나 어노테이션으로 트랜잭션을 관리할 수 있다.
5. 편리한  MVC구조 <br>
  스프링은 자체적으로 MVC프레임워크를 제공하여 개발자가 불필요한 코드를 줄일 수 있게 도와준다.
6. WAS에 종속적이지 않음<br> 
  스프링 프레임워크를 사용한 프로젝트는 특정 WAS만 사용 가능한 것이 아니라 다양한 서버에서 동작할 수 있다. <br> 
  또한 was없이도 독립적인 테스트가 가능하여 테스트가 쉽고 빠르다.



### - IoC(제어권의 역전 : Inversion of Control)
  * 객체의 입장에서 사용할 다른 객체를 직접 생성하여 제어한다. 이러한 개발이 일반적인 제어 흐름이다. 
  * 제어권의 역전이란 이러한 흐름을 반대로 뒤집은 것으로 객체가 사용하는 다른 객체를 직접 생성하지도 않으며 자기 자신도 어디서 사용되는지 알 수 없다. 특별한 권한을 가진 
  다른 객체에 의해 결정되고 만들어진다.
<br> <br> 

### - IoC컨테이너
  * 스프링에서 객체 생성, 관리 의존성 주입을 담당하는 주요 컴포넌트
  * IoC컨테이너는 논리적인 구조이다 <br>
    즉, 실체가 아니며 IoC컨테이너란는 논리적 구조를 바탕으로 스프링에서 사용하는 실제 구현객체는 BeanFactory와 ApplicationContext 객체이다.
    BeanFactory는 가장 기본적인 IoC컨테이너 기능을 제공하며, ApplicationContext는 좀 더 업그레이드 되어 추가 기능을 제공한다.

## 프로젝트 경로
1. src/main/java : 서버에서 사용하는 java파일
2. src/test/java : 단위 테스트 java파일
3. src/main/resource : 설정파일, 뷰
4. resource/static : css, js 파일
5. resource/templates : html 파일
6. pom.xml 또는 build.gradle : 라이브러리 의존성 관리
7. application.properties : 서버, DB, 라이브러리 생성파일












