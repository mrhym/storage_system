package com.alibaba.hym.rt.storageSystem.activity;

import com.alibaba.hym.rt.storageSystem.api.MessageService;
import com.alibaba.hym.rt.storageSystem.model.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/6 14:38
 **/
@Service
public class MessageServiceActivity implements MessageService {

    @Override
    public Result publishMessage(String message) {
        return Result.success();
    }

    @Override
    public Result acceptMessage() {
        return null;
    }
}
