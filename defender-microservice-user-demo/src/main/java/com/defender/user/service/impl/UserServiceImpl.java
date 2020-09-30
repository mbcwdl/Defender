package com.defender.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.defender.user.entity.User;
import com.defender.user.mapper.UserMapper;
import com.defender.user.query.UserQuery;
import com.defender.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 * UserMapper对象不需要手动注入，
 * 它已经被注入到父类ServiceImpl的baseMapper成员变量中了，
 * 我们可以直接使用。
 * @author guanlibin
 * @since 2020-09-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void pageQuery(Page<User> pageParam, UserQuery userQuery) {

        // QueryWrapper继承自AbstractWrapper,具有大量的条件构造方法
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if (userQuery == null) {
            // 没有查询条件。这个baseMapper存放着UserMapper的实现类对象
            baseMapper.selectPage(pageParam, queryWrapper);
            return;

        }

        String username = userQuery.getUsername();
        String phone = userQuery.getPhone();

        if (!StringUtils.isBlank(username)) {
            queryWrapper.like("username", username);
        }

        if (!StringUtils.isBlank(phone)) {
            queryWrapper.eq("phone", phone);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
