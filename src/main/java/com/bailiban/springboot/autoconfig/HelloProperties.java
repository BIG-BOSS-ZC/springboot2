package com.bailiban.springboot.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello")
@Data
public class HelloProperties {

    private static String MSG = "World";

//    自动匹配hello.msg，并赋值
    private String msg = MSG;
}
