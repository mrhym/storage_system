package com.alibaba.hym.rt.storageSystem.web.controller;

import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.rocketmq.MessageProducer;
import com.alibaba.hym.rt.storageSystem.service.webSocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/14 13:27
 **/
@RestController
public class WebSocketController {


        @RequestMapping("/socket/push/{message}")
        public Result pushToWeb(@PathVariable  String message) {
            try {
                WebSocketServer.sendInfo(message);
            } catch (IOException e) {
                e.printStackTrace();
                return Result.error(e.getMessage());
            }
            return Result.success();
        }
    }

