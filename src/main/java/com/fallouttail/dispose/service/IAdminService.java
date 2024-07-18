package com.fallouttail.dispose.service;

import com.fallouttail.dispose.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-09
 */
public interface IAdminService extends IService<Admin> {

    Admin login(Admin admin);
}
