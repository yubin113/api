package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")  //공통 URL 설정
public class GetController {
    //html://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)//GET형식의 요청만 받는다
    public String getHello(){
        return "Hello World";
    }

    @GetMapping(value = "/name")  //매개변수 없이 구현
    public String GetName(){
        return "Flature";
    }

    //html://localhost:8080/api/v1/get-api/variable1/{String 값}
    //위 주석에서 String 값을 받아 요청한다.
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }
    //만약 어노테이션의 변수와 메소드 매개변수의 이름이 동일하게 맞추기 어렵다면
    //@PathVariable("variable") String var 이런 식으로 사용할 것

    //쿼리로 맵핑
    //html://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request1")
    public String getReqeustParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    //매개변수 항목이 일정하지 않는 경우에는 map을 사용하는 것이 효율적
    //html://localhost:8080/api/v1/get-api/request2/?ket1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        //return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
        return memberDto.toString();
    }
}
