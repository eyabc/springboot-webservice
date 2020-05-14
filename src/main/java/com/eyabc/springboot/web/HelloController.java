package com.eyabc.springboot.web;

import com.eyabc.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
/*
    @RestController
    컨트롤러를 JSON 을 반환하는 컨트롤러로 만들어 준다.
    예전에는 @ResponseBody 를 각 메서드마다 선언했었다.

    @GetMapping
    HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
    예전에는 @ResponseMapping으로 사용되었다.

    @RequestParam
    외부에서 API로 넘긴 파라미터를 가져오는 어노테이션이다.
    외부에서 name 이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장하게 된다.
* */