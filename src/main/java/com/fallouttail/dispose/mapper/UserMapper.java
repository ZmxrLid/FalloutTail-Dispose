package com.fallouttail.dispose.mapper;

import com.fallouttail.dispose.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select user_name from user where user_id = #{userId}")
    String select(Integer userId);
}
