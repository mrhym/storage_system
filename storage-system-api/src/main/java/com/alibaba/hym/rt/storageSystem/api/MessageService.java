package com.alibaba.hym.rt.storageSystem.api;

import com.alibaba.hym.rt.storageSystem.model.Result;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/6 14:37
 **/

public interface MessageService {
    public Result publishMessage(String message);
    public Result acceptMessage();
}
