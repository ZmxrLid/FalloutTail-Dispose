package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IListforcomService;
import com.fallouttail.dispose.entity.Listforcom;

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
@RequestMapping("/listforcom")
public class ListforcomController {
    @Resource
    private IListforcomService listforcomService;

    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody Listforcom listforcom) {
        return listforcomService.saveOrUpdate(listforcom);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return listforcomService.removeById(id);
    }

    //批量删除
    @PostMapping("/deleall")
    public Boolean deleteall(@RequestBody List<Integer> allid) {
        return listforcomService.removeByIds(allid);
    }

    //相同商品
    @GetMapping("/getid")
    public List<Listforcom> findxiangtong(@RequestParam String listCommId,@RequestParam Integer listUserId){
        QueryWrapper<Listforcom> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("list_comm_id",listCommId).eq("list_user_id",listUserId);
        return listforcomService.list(queryWrapper);
    }

    //获取所有
    @GetMapping
    public List<Listforcom> findAll(@RequestParam Integer listUserId) {
        QueryWrapper<Listforcom> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("list_user_id",listUserId);
        return listforcomService.list(queryWrapper);
    }

    //分页查询
    @GetMapping("/page")
    public Page<Listforcom> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Listforcom> queryWrapper = new QueryWrapper<>();
        return listforcomService.page(new Page<>(pageNum, pageSize));
    }
}

