package com.springboot.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    //http://localhost:8080/api/v1/delete-api/{String 값}
    @DeleteMapping(value = "/{variable}")  //DeleteVariable에서 정의한 매개변수와 같은 매개변수 사용할 것
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

}
