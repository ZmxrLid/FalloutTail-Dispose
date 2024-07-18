package com.fallouttail.dispose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallouttail.dispose.entity.User;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fallouttail.dispose.service.IMessageService;
import com.fallouttail.dispose.entity.Message;

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
@RequestMapping("/message")
public class MessageController {
    @Resource
    private IMessageService messageService;

    //新增或修改
    @PostMapping
    public Boolean save(@RequestBody Message message) {
        return messageService.saveOrUpdate(message);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return messageService.removeById(id);
    }

    //获取所有
    @GetMapping
    public List<Message> findAll(@RequestParam(defaultValue = "")String messName) {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("mess_user_id",messName);
        queryWrapper.or().like("mess_intro",messName);
        queryWrapper.or().like("mess_date",messName);
        return messageService.list(queryWrapper);
    }

    @GetMapping("/byid")
    public List<Message> findById(Integer messid) {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mess_id",messid);
        return messageService.list(queryWrapper);
    }

    //分页查询
    @GetMapping("/page")
    public Page<Message> findPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize,
                                  @RequestParam(defaultValue = "") String messName) {
        Page<Message> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("mess_id",messName);
        queryWrapper.or().like("mess_user_id",messName);
        queryWrapper.or().like("mess_intro",messName);
        queryWrapper.or().like("mess_date",messName);
        return messageService.page(page,queryWrapper);
    }
}

