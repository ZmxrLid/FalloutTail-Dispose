package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.entity.Listforcom;
import com.fallouttail.dispose.entity.Orders;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IExorderService;
import com.fallouttail.dispose.entity.Exorder;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-16
 */
@RestController
@RequestMapping("/exorder")
public class ExorderController {
    @Resource
    private IExorderService exorderService;

    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody Exorder exorder) {
        return exorderService.saveOrUpdate(exorder);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return exorderService.removeById(id);
    }

    //获取所有
    @GetMapping
    public List<Exorder> findAll(@RequestParam Integer exorderUserId) {
        QueryWrapper<Exorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("exorder_user_id",exorderUserId);
        return exorderService.list(queryWrapper);
    }

    //分页查询
    @GetMapping("/page")
    public Page<Exorder> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String exordersName){
        Page<Exorder> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Exorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("exorder_id",exordersName);
        queryWrapper.or().like("exorder_user_id",exordersName);
        queryWrapper.or().like("exorder_ex_id",exordersName);
        queryWrapper.or().like("exorder_date",exordersName);
        return exorderService.page(page,queryWrapper);
    }
}

