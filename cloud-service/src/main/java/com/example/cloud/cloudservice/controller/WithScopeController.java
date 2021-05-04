package com.example.cloud.cloudservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class WithScopeController {

    //要设置spring.profiles.active
    @Value("${b1.b2.b3}")
    private String bbb;

    @GetMapping("/test1")
    public String welcome() {
        return bbb;
    }
}
