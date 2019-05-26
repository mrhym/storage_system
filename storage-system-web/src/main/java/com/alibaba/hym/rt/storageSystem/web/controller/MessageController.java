package com.alibaba.hym.rt.storageSystem.web.controller;

import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.exception.MessageProducerException;
import com.alibaba.hym.rt.storageSystem.service.rocketmq.MessageConsumer;
import com.alibaba.hym.rt.storageSystem.service.rocketmq.MessageProducer;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/16 16:31
 **/
@Slf4j
@RequestMapping("message")
@RestController
public class MessageController {
    @Value("${rocketmq.messageConsumer.topic}")
    private String topic;
    @Resource
    private MessageProducer producer;

    private boolean flag = true;

    @RequestMapping("send")
    public Result sendMessage(String message){
        try {
            System.out.println(message);
           SendResult sendResult = producer.sendMessage(topic,message);
           System.out.println(sendResult.getSendStatus());
        } catch (MessageProducerException e) {
            e.printStackTrace();
        }catch (Exception e){
            log.info("send message is error : {}",e.toString());
            return Result.error(e.toString());
        }
        return Result.success(message);
    }
}
