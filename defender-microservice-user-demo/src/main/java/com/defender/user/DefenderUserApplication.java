package com.defender.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author guanlibin
 * @version 1.0
 * @create 2020/9/30 9:09
 */
@SpringBootApplication
// 不要忘记扫描common
@ComponentScan(basePackages = {"com.defender.user","com.defender.common"})
public class DefenderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DefenderUserApplication.class);
    }
}
