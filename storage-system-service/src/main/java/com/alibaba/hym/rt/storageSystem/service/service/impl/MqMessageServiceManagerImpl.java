package com.alibaba.hym.rt.storageSystem.service.service.impl;

import com.alibaba.hym.rt.storageSystem.service.dao.MqMessageDAO;
import com.alibaba.hym.rt.storageSystem.service.model.MessageDTO;
import com.alibaba.hym.rt.storageSystem.service.service.MqMessageServiceManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/17 13:19
 **/
@Service
public class MqMessageServiceManagerImpl implements MqMessageServiceManager {
    @Resource
    MqMessageDAO messageDAO;

    @Override
    public Integer saveMQMessageInfo(MessageDTO messageDTO) {
        return messageDAO.insert(messageDTO);
    }
}
