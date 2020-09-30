package com.defender.user.service.impl;

import com.defender.user.entity.User;
import com.defender.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author guanlibin
 * @version 1.0
 * @create 2020/9/30 9:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void save() {

        User user = new User();
        user.setUsername("guanlibin");
        user.setPhone("152520");

        userService.save(user);
    }
}