package com.bailiban.springboot.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnProperty(prefix = "hello", name = "enabled", matchIfMissing = true)
public class HelloAutoConfiguration {

    @Bean
    public Hello  hello(HelloProperties properties) {
        Hello hello = new Hello(properties.getMsg());
        return hello;
    }
}
