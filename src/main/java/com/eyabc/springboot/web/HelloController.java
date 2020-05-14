package com.eyabc.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* @RestController
    컨트롤러를 JSON 을 반환하는 컨트롤러로 만들어 준다.
    예전에는 @ResponseBody 를 각 메서드마다 선언했었다.
* */
@RestController
public class HelloController {

    /* @GetMapping
    * HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
    * 예전에는 @ResponseMapping으로 사용되었다.
    * */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
