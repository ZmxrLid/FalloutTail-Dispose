package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.common.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IAdminService;
import com.fallouttail.dispose.entity.Admin;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-09
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private IAdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody Admin admin) {
        String adminname = admin.getAdminName();
        String adminpassword = admin.getAdminPassword();
        if (StringUtils.isBlank(adminname)||StringUtils.isBlank(adminpassword)){
            return Result.error();
        }
        Admin dto = adminService.login(admin);
        if (dto!=null){
            return Result.suc(dto);
        }
        return Result.error();
    }


}

