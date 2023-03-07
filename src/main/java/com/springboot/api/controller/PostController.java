package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    //POST API
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    //http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")  //requestmapping에서 postmapping쓰면 method 정의안해도 된다.
    public String postMember(@RequestBody Map<String, Object> postData){ //@Requestbody: http body내용을 해당 어노테이션이 지정된
        // 객체에 매핑하는 역할을 한다.
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    //http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

}
