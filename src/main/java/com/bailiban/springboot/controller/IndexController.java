package com.bailiban.springboot.controller;

import com.bailiban.springboot.autoconfig.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private Hello hello;

    @RequestMapping({"index",""})
    public String index(){
        return hello.getMsg();
    }
}
