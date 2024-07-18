package com.fallouttail.dispose.service;

import com.fallouttail.dispose.common.Result;
import com.fallouttail.dispose.entity.Admin;
import com.fallouttail.dispose.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-09
 */
public interface IUserService extends IService<User> {

    User login(User user);

    User select(Integer userId);

//    String select(Integer userId);

//    String select(Integer userId);

//    @Select("select user_name from user where user_name = #{userId}")
//    String select(Integer userId);
}
