package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.limit.Limit;

@RestController
public class Limiter {

	private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();



    @Limit(key = "test", period = 100, count = 2)

    @GetMapping("/test")

    public int testLimiter() {

        // 意味著 100S 内最多允許訪問10次
    	
  

        return ATOMIC_INTEGER.incrementAndGet();

    }
	
	
}
