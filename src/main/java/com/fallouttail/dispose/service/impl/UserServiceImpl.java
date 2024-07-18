package com.fallouttail.dispose.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fallouttail.dispose.common.Result;
import com.fallouttail.dispose.entity.Admin;
import com.fallouttail.dispose.entity.User;
import com.fallouttail.dispose.mapper.UserMapper;
import com.fallouttail.dispose.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",user.getUserName());
        queryWrapper.eq("user_password",user.getUserPassword());
        User dto = getOne(queryWrapper);
        return dto;
    }

    public User select(Integer userId){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_Id",userId);
        return getOne(queryWrapper);
    }
}
