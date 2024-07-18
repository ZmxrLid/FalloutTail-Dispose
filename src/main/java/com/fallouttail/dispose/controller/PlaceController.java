package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.entity.Listforcom;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IPlaceService;
import com.fallouttail.dispose.entity.Place;

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
@RequestMapping("/place")
public class PlaceController {
    @Resource
    private IPlaceService placeService;

    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody Place place) {
        return placeService.saveOrUpdate(place);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return placeService.removeById(id);
    }

    //获取所有
    @GetMapping
    public List<Place> findAll(@RequestParam Integer placeUserId) {
        QueryWrapper<Place> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("place_user_id",placeUserId);
        return placeService.list(queryWrapper);
    }

    //分页查询
    @GetMapping("/page")
    public Page<Place> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Place> queryWrapper = new QueryWrapper<>();
        return placeService.page(new Page<>(pageNum, pageSize));
    }
}

