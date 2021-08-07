package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/save")
    public void saveMember(@RequestBody Member member){ //, HttpServletRequest request : request에 대한 직접적인 조작
        memberService.save(member);
    }

    @GetMapping("/{key}")
    public Member getMember(@PathVariable("key") Long key, @RequestParam(required=false) String name){
        if(name != null){
            return memberService.findMember(key, name);
        }else{
            return memberService.findMember(key);
        }
    }

    @GetMapping("/api/count")
    public List<Object> countByOrgGroup(@RequestParam Boolean isActive){
        return memberService.countOrgGroup(isActive);
    }

}
