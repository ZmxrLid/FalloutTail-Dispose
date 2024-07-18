package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.entity.Listforcom;
import com.fallouttail.dispose.entity.User;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IOrdersService;
import com.fallouttail.dispose.entity.Orders;

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
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private IOrdersService ordersService;

    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody Orders orders) {
        return ordersService.saveOrUpdate(orders);
    }

    //批量插入
    @PostMapping("allin")
    public boolean allin(@RequestParam String ordersPlace,@RequestBody List<Listforcom> listforcoms){
        for (Listforcom oo:listforcoms){
            Orders aa = new Orders();
            aa.setOrdersComId(oo.getListCommId());
            aa.setOrdersNum(oo.getListNum());
            aa.setOrdersState("未发货");
            aa.setOrdersPrice(oo.getListPrice());
            aa.setOrdersUserId(oo.getListUserId());
            aa.setOrdersPlace(ordersPlace);
            boolean a = ordersService.save(aa);
            if (!a){
                return false;
            }
        }
        return true;
    }



    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return ordersService.removeById(id);
    }

    //获取所有
    @GetMapping
    public List<Orders> findAll(@RequestParam Integer ordersUserId) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("orders_user_id",ordersUserId);
        return ordersService.list(queryWrapper);
    }

    //分页查询
    @GetMapping("/page")
    public Page<Orders> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String ordersName){
        Page<Orders> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("orders_id",ordersName);
        queryWrapper.or().like("orders_user_id",ordersName);
        queryWrapper.or().like("orders_state",ordersName);
        queryWrapper.or().like("orders_date",ordersName);
        queryWrapper.or().like("orders_com_id",ordersName);
        return ordersService.page(page,queryWrapper);
    }
}

