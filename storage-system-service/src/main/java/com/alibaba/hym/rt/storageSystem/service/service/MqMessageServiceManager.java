package com.alibaba.hym.rt.storageSystem.service.service;

import com.alibaba.hym.rt.storageSystem.service.model.MessageDTO;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/17 13:18
 **/

public interface MqMessageServiceManager {
    public Integer saveMQMessageInfo(MessageDTO messageDTO);
}
