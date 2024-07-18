package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.entity.Exorder;
import com.fallouttail.dispose.entity.User;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IExhibitionService;
import com.fallouttail.dispose.entity.Exhibition;

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
@RequestMapping("/exhibition")
public class ExhibitionController {
    @Resource
    private IExhibitionService exhibitionService;

    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody Exhibition exhibition) {
        return exhibitionService.saveOrUpdate(exhibition);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return exhibitionService.removeById(id);
    }

    //获取所有
    @GetMapping
    public List<Exhibition> findAll(@RequestParam(defaultValue = "") String exName) {
        QueryWrapper<Exhibition> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("ex_name",exName);
        queryWrapper.or().like("ex_introduce",exName);
        queryWrapper.or().like("ex_date",exName);
        queryWrapper.or().like("ex_place",exName);
        queryWrapper.or().like("ex_place_select",exName);
        queryWrapper.or().like("ex_people",exName);
        return exhibitionService.list(queryWrapper);
    }

    @GetMapping("allbyid")
    public List<Exhibition> findAlll(@RequestParam(defaultValue = "") Integer exId) {
        QueryWrapper<Exhibition> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("ex_id",exId);
        return exhibitionService.list(queryWrapper);
    }

    //分页查询
    @GetMapping("/page")
    public Page<Exhibition> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                     @RequestParam(defaultValue = "") String exName){
        Page<Exhibition> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Exhibition> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("ex_name",exName);
        queryWrapper.or().like("ex_introduce",exName);
        queryWrapper.or().like("ex_id",exName);
        queryWrapper.or().like("ex_date",exName);
        queryWrapper.or().like("ex_place",exName);
        queryWrapper.or().like("ex_place_select",exName);
        queryWrapper.or().like("ex_people",exName);
        return exhibitionService.page(page,queryWrapper);
    }
}

