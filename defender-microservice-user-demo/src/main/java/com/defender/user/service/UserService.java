package com.defender.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.defender.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.defender.user.query.UserQuery;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author guanlibin
 * @since 2020-09-30
 */
public interface UserService extends IService<User> {

    void pageQuery(Page<User> pageParam, UserQuery userQuery);
}
