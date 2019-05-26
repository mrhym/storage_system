package com.alibaba.hym.rt.storageSystem.service.rocketmq;

import com.alibaba.hym.rt.storageSystem.service.exception.MessageProducerException;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/16 13:43
 **/
@Component
@PropertySource(value = "application.properties")
public class MessageProducer {
    @Value("${rocketmq.groupName}")
    private String groupName;

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    private DefaultMQProducer producer;

    private final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

    @PostConstruct
    public void init() throws MessageProducerException {
        if (StringUtils.isEmpty(groupName)) {
            LOGGER.info("groupName is empty : {}", groupName);
            throw new MessageProducerException();
        }
        if (StringUtils.isEmpty(namesrvAddr)) {
            LOGGER.info("namesrvAddr is empty : {}", namesrvAddr);
            throw new MessageProducerException();
        }
        this.producer = new DefaultMQProducer(this.groupName);
        this.producer.setNamesrvAddr(this.namesrvAddr);

        try {
            this.producer.start();
            LOGGER.info("messageProducer is start now ! groupName: {}, namesrvAddr :{}", groupName, namesrvAddr);
        } catch (MQClientException e) {
            e.printStackTrace();
            LOGGER.error("messageProducer is error now ! groupName: {}, namesrvAddr :{}, error messge : {}", groupName, namesrvAddr, e);
            throw new MessageProducerException();
        }
    }

    public SendResult sendMessage(String topic,String messageText) throws MessageProducerException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        if (StringUtils.isEmpty(topic)) {
            throw new MessageProducerException();
        }
        Message message = new Message(topic,"push",messageText.getBytes());
        SendResult sendResult = this.producer.send(message);
        return sendResult;
    }
}
