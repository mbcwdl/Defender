package com.defender.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author guanlibin
 * @version 1.0
 * @since 2020/10/9 10:11
 */
@EnableEurekaServer
@SpringBootApplication
public class DefenderRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DefenderRegistryApplication.class);
    }
}
