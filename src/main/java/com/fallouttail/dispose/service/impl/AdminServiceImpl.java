package com.fallouttail.dispose.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.entity.Admin;
import com.fallouttail.dispose.entity.User;
import com.fallouttail.dispose.mapper.AdminMapper;
import com.fallouttail.dispose.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-09
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Override
    public Admin login(Admin admin) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_name",admin.getAdminName());
        queryWrapper.eq("admin_password",admin.getAdminPassword());
        Admin dto = getOne(queryWrapper);
        return dto;
    }
//    @GetMapping("/page")
//    public Page<User> findPage(@RequestParam Integer pageNum,
//                               @RequestParam Integer pageSize,
//                               @RequestParam(defaultValue = "") String userName){
//        Page<User> page = new Page<>(pageNum,pageSize);
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("user_name",userName);
//        queryWrapper.or().like("user_tel",userName);
//        queryWrapper.or().like("user_id",userName);
//        return userService.page(page,queryWrapper);
//    }
}
