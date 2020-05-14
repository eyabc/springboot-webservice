package com.eyabc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* @SpringBootApplication 으로 인해 스프링부트의 자동 설정, 스프링 Bean 읽기와
* 생성을 모두 자동으로 설정된다. @SpringBootApplication이 있는 위치부터
* 설정을 읽어가기 때문에 항상 프로젝트의 최상단에 위치해야 한다.  */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /* SpringApplication.run:
         내장 WAS(Web Application Server)를 실행한다.
         내장 WAS:
         별도로 외부터 WAS 를 두지 않고 어플리케이션을 내부에서 실행하는것.
         항상 서버에 톰캣을 설치할 필요가 없게 되며,
         스프링부트로 만들어진 Jar 파일 (실행가능한 Java 패키징 파일)로 실행하면 된다.
         스프링부트에서 내장 WAS 사용을 권장하고 있는 이유는 '언제 어디서나 같은 환경에서 스프링 부트를 배포' 할 수 있기 때문이다.
         외장 WAS 를 쓴다면 모든 서버는 WAS의 종류와 버전, 설정을 일치시켜야 한다. 새로운 서버가 추가되면 모든 서버가 같은 WAS 환경을 구축해야 한다.

        */
        SpringApplication.run(Application.class, args);
    }
}
