package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.entity.Exhibition;
import com.fallouttail.dispose.entity.User;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.ICommodityService;
import com.fallouttail.dispose.entity.Commodity;

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
@RequestMapping("/commodity")
public class CommodityController {
    @Resource
    private ICommodityService commodityService;

    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody Commodity commodity) {
        return commodityService.saveOrUpdate(commodity);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return commodityService.removeById(id);
    }

    //获取所有
    @GetMapping
    public List<Commodity> findAll(@RequestParam(defaultValue = "") String coName) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("com_name",coName);
        queryWrapper.or().like("com_introduce",coName);
        queryWrapper.or().like("com_id",coName);
        queryWrapper.or().like("com_price",coName);
        queryWrapper.or().like("com_brand",coName);
        queryWrapper.or().like("com_classify",coName);
        return commodityService.list(queryWrapper);
    }

    @GetMapping("listku")
    public List<Commodity> findAlllistku(@RequestParam(defaultValue = "") String kuName) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("com_name",kuName);
        return commodityService.list(queryWrapper);
    }

    @GetMapping("allbyid")
    public List<Commodity> findAlll(@RequestParam(defaultValue = "") Integer comId) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("com_id",comId);
        return commodityService.list(queryWrapper);
    }

    //分页查询
    @GetMapping("/page")
    public Page<Commodity> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam(defaultValue = "") String comName){
        Page<Commodity> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("com_name",comName);
        queryWrapper.or().like("com_introduce",comName);
        queryWrapper.or().like("com_id",comName);
        queryWrapper.or().like("com_price",comName);
        queryWrapper.or().like("com_Brand",comName);
        return commodityService.page(page,queryWrapper);
    }


}

