package com.example.demo.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeTraceApp {

    @Around("execution(* com.example..*(..))")
    public Object execute(ProceedingJoinPoint jointPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Start : " + jointPoint.toString());
        try {
            return jointPoint.proceed();
        } finally {
            long finish =System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("End : " + jointPoint.toString() + " " + timeMs + "ms");
        }
    }
}
