package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.entity.User;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IAppraiseService;
import com.fallouttail.dispose.entity.Appraise;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-09
 */
@RestController
@RequestMapping("/appraise")
public class AppraiseController {
    @Resource
    private IAppraiseService appraiseService;

    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody Appraise appraise) {
        return appraiseService.saveOrUpdate(appraise);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return appraiseService.removeById(id);
    }

    //获取所有
    @GetMapping
    public List<Appraise> findAll() {
        return appraiseService.list();
    }

    //分页查询
    @GetMapping("/page")
    public Page<Appraise> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String appraiseName){
        Page<Appraise> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Appraise> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("appraise_id",appraiseName);
        queryWrapper.or().like("appraise_con",appraiseName);
        queryWrapper.or().like("appraise_orders_id",appraiseName);
        queryWrapper.or().like("appraise_date",appraiseName);
        return appraiseService.page(page,queryWrapper);
    }
}

