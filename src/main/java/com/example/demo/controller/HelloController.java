package com.example.demo.controller;

import com.example.demo.model.Hello;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class HelloController {

    MemberService memberService;

    @Autowired
    private void setMemberService(MemberService memberService){
        this.memberService = memberService;
    }

//    @GetMapping("hello-mvc")
//    public String helloTemplate(String name, Model model){
//        model.addAttribute("name", name);
//        return "hello-template";
//    }
//
//    @GetMapping("hello-string")
//    @ResponseBody
//    public String helloString(String name){return memberService.greet(name);}
//
//    @GetMapping("hello-map")
//    @ResponseBody
//    public Map<String, Object> helloMap(String name){
//        Map<String, Object> m = new HashMap<>();
//        m.put("name", name);
//        return m;
//    }
//
//    @GetMapping("hello-object")
//    @ResponseBody
//    public Hello helloObject(String name){
//        Hello h = new Hello(name);
//        System.out.println(h);
//        return h;
//    }
    @PostConstruct
    public void postConstruct(){
        log.info("I am already CONSTRUCTED");
    }

    @PreDestroy // 종료되는 시점에서 이 method가 실행되지 않을 가능성이 매우 옾다.
    // gracefully 하게 종료되어야 한다. sigint(method 실행 후 종료 ), sigkill(바로 종료)
    public void preDestroy() {
        log.info("I will be destroyed");
    }



}
