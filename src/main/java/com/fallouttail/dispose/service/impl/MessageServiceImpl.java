package com.fallouttail.dispose.service.impl;

import com.fallouttail.dispose.entity.Message;
import com.fallouttail.dispose.mapper.MessageMapper;
import com.fallouttail.dispose.service.IMessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
