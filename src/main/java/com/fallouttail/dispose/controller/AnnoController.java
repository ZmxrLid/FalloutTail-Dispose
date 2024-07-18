package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.entity.User;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IAnnoService;
import com.fallouttail.dispose.entity.Anno;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-10
 */
@RestController
@RequestMapping("/anno")
public class AnnoController {
    @Resource
    private IAnnoService annoService;

    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody Anno anno) {
        return annoService.saveOrUpdate(anno);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return annoService.removeById(id);
    }

    //获取所有
    @GetMapping
    public List<Anno> findAll() {
        return annoService.list();
    }

    //分页查询
    @GetMapping("/page")
    public Page<Anno> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String annoName) {
        Page<Anno> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Anno> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("anno_id",annoName);
        queryWrapper.or().like("anno_introduce",annoName);
        queryWrapper.or().like("anno_date",annoName);
        queryWrapper.or().like("anno_admin_id",annoName);
        queryWrapper.or().like("anno_title",annoName);
        return annoService.page(page,queryWrapper);
    }
}

