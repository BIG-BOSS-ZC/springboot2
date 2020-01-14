package com.bailiban.springboot.autoconfig;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hello {

    private String msg;

    public String sayHello() {
        return "Hello " + msg + "!";
    }
}
