package com.fallouttail.dispose.service.impl;

import com.fallouttail.dispose.entity.Orders;
import com.fallouttail.dispose.mapper.OrdersMapper;
import com.fallouttail.dispose.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-10
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
