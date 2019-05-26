package com.alibaba.hym.rt.storageSystem.service.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/6 13:08
 **/
@Slf4j
@Component
@PropertySource(value = "application.properties")
public class MessageConsumer {
    @Value("${rocketmq.groupName}")
    private String groupName;

    @Value("${rocketmq.messageConsumer.topic}")
    private String topic;

    @Value("${rocketmq.messageConsumer.tags}")
    private String tags;

    private final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    private DefaultMQPushConsumer consumer;

    @Resource
    private IMessageProcessor messageProcessor;

    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(this.groupName);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(this.topic, "push");
        MessageListener messageListener = new MessageListener();
        messageListener.setMessageProcessor(messageProcessor);
        consumer.registerMessageListener(messageListener);
        log.info("consumer is start now ,groupName: {}, topic: {}", groupName, topic);
        consumer.start();
    }
}