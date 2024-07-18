package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.common.Result;
import com.fallouttail.dispose.entity.Admin;
import com.fallouttail.dispose.entity.Listforcom;
import com.fallouttail.dispose.service.impl.UserServiceImpl;
//import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IUserService;
import com.fallouttail.dispose.entity.User;

import org.springframework.web.bind.annotation.RestController;

import com.fallouttail.dispose.mapper.UserMapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-09
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private UserMapper userMapper;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        String username = user.getUserName();
        String userpassword = user.getUserPassword();
        if (StringUtils.isBlank(username)||StringUtils.isBlank(userpassword)){
            return Result.error();
        }
        User dto = userService.login(user);
        if (dto!=null){
            return Result.suc(dto);
        }
        return Result.error();
    }


    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody User user) {
        try {
            // 程序代码
            userService.saveOrUpdate(user);
        } catch (Exception e){
            return false;
        }
        return userService.saveOrUpdate(user);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    //获取所有
    @GetMapping
    public List<User> findAll() {
        return userService.list();
    }

    @GetMapping("/nameById")
    public Result findUserName(@RequestParam Integer userId) {
        Result result = new Result();
        result.setData(userService.select(userId));
        result.setReally(true);
        return result;
    }

    //分页查询
    @GetMapping("/page")
    public Page<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String userName){
        Page<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name",userName);
        queryWrapper.or().like("user_tel",userName);
        queryWrapper.or().like("user_id",userName);
        return userService.page(page,queryWrapper);
    }

}

