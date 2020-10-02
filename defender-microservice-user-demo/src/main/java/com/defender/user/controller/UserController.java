package com.defender.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.defender.common.exception.DefenderException;
import com.defender.common.vo.R;
import com.defender.user.entity.User;
import com.defender.user.query.UserQuery;
import com.defender.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * 定义了rest风格的增删改查
 * 以及分页和条件查询 相关方法。
 *
 * UserService由mybatis-plus自动生成，继承了IService接口
 * IService接口定义了大量的通用方法，可以使用它们完成大多数业务需求。
 *
 * @author guanlibin
 * @since 2020-09-30
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有用户")
    @GetMapping
    public R list() {

        List<User> users = userService.list();

        return R.ok().data("users",users);
    }

    @ApiOperation(value = "查询某一用户")
    @GetMapping("{id}")
    public R retrieve(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") String id) {

        // 采用的雪花算法生成的id为19位
        if (StringUtils.isBlank(id) || id.length() != 19) {
            // 记录日志。类上加@Slf4j注解，我们就可以直接使用log这个对象来记录日志了。
            // 日志会输出到本地，输出的位置在logback-spring.xml中配置
            log.info("[用户中心]用户id为{},错误原因:{}", id, "参数不合法");

            // 传过来的id参数不正确，我们就可以直接抛出自定义异常。

            // 方式一
            throw new DefenderException(400, "用户id不合法");

            // 方式二 使用common工程里的CommonResponseResultEnum中已经定义好的枚举对象
            // throw new DefenderException(CommonResponseResultEnum.PARAM_ERROR);

            // 方式三 在本工程中定义枚举类
            /*throw new DefenderException(UserResponseResultEnum.USER_ID_ILLEGAL.getCode(),
                    UserResponseResultEnum.USER_ID_ILLEGAL.getMessage());*/
        }

        User user = userService.getById(id);

        return R.ok().data("user",user);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping
    public R save(
            @ApiParam(value = "用户对象", required = true)
            @RequestBody User user) {

        // 新增用户时需要检验username和phone的格式，可以使用hibernate-validator
        userService.save(user);

        // 可以自定义状态码和消息
        return R.ok().code(2000).message("新增用户成功");
    }

    /**
     * put方法用于指定id新增用户，或者根据id修改用户信息
     * 这里因为id必须由后端生成，所以不允许指定id新增用户
     * @param id
     * @param user
     * @return
     */
    @ApiOperation(value = "修改某一用户")
    @PutMapping("{id}")
    public R update(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") String id,

            @ApiParam(value = "用户对象", required = true)
            @RequestBody User user) {

        user.setId(id);

        // 实现乐观锁的话需要先从数据库中查出version
        User u = userService.getById(id);
        user.setVersion(u.getVersion());

        userService.updateById(user);

        return R.ok();
    }

    @ApiOperation(value = "删除某一用户")
    @DeleteMapping("{id}")
    public R delete(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") String id) {

        userService.removeById(id);

        return R.ok();
    }


    @ApiOperation(value = "条件查询用户并分页")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(value = "当前页码")
            @PathVariable("page") Long page,

            @ApiParam(value = "页数")
            @PathVariable("limit") Long limit,

            @ApiParam(value = "用户查询对象") UserQuery userQuery) {

        // mybatis-plus需要开启分页插件
        Page<User> pageParam = new Page<>(page, limit);

        userService.pageQuery(pageParam, userQuery);

        // 解析分页结果对象
        long currentPage = pageParam.getCurrent();
        long size = pageParam.getSize();
        long total = pageParam.getTotal();
        List<User> users = pageParam.getRecords();

        // 可以将需要传递给前端的参数封装成功一个map
        Map<String, Object> map = new HashMap<>();
        map.put("users", users);

        return R.ok().data(map);
    }
}

