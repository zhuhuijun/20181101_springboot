package com.zzbj.config.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
public class MyController {
    @Value("${foo}")
    String foo;
    @RequestMapping("/foo")
    public String hi(){
        return  foo;
    }
}
