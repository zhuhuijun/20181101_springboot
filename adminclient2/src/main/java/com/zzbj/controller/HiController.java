package com.zzbj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/7/3 9:50
 **/
@RestController
public class HiController {
   @Value("${server.port}")
    String port;
    @GetMapping("/hi")
    public String hi(@RequestParam(required = false,defaultValue = "cralor")String name){
        return "hi "+name+",i am lucy and from port:"+port;
    }
    public String hiError(String name){
        return "hi "+name+",sorry,error!";
    }
}
