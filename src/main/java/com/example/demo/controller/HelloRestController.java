package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.model.Hello;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController // @Controller + @ResponseBody
public class HelloRestController {

    private final MemberService memberService;

    @Autowired
    public HelloRestController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("hello-string")
    public String helloString(String name){return memberService.greet(name);}

    @GetMapping("hello-map")
    public Map<String, Object> helloMap(String name){
        Map<String, Object> m = new HashMap<>();
        m.put("name", name);
        return m;
    }

    @GetMapping("hello-object")
    public Hello helloObject(String name){
        Hello h = new Hello(name);
        System.out.println(h);
        return h;
    }

}
