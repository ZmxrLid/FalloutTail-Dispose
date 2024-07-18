package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.entity.Message;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IMeorderService;
import com.fallouttail.dispose.entity.Meorder;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-28
 */
@RestController
@RequestMapping("/meorder")
public class MeorderController {
    @Resource
    private IMeorderService meorderService;

    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody Meorder meorder) {
        return meorderService.saveOrUpdate(meorder);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return meorderService.removeById(id);
    }

    //获取所有
    @GetMapping
    public List<Meorder> findAll() {
        return meorderService.list();
    }

    //获取所有
    @GetMapping("/allbyid")
    public List<Meorder> findAllById(@RequestParam Integer messid) {
        QueryWrapper<Meorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("meorder_messid",messid);
        return meorderService.list(queryWrapper);
    }

    //分页查询
    @GetMapping("/page")
    public Page<Meorder> findPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize,
                                  @RequestParam(defaultValue = "") String messName) {
        Page<Meorder> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Meorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("meorder_messid",messName);
        return meorderService.page(page,queryWrapper);
    }
}

