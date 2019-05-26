package com.alibaba.hym.rt.storageSystem.service.rocketmq;

import org.apache.rocketmq.common.message.MessageExt;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/16 16:05
 **/

public interface IMessageProcessor {
    public boolean handMessage(MessageExt message);
}
