package com.defender.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author guanlibin
 * @version 1.0
 * @since 2020/10/9 10:58
 */
@EnableZuulProxy
@SpringBootApplication
public class DefenderGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DefenderGatewayApplication.class);
    }
}
