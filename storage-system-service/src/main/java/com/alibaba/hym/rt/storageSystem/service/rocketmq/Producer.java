package com.alibaba.hym.rt.storageSystem.service.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/6 13:08
 **/

public class Producer {

    private final String NAME_SRV_ADDR = "127.0.0.1:9076";
    private String producerGroup;
    private String topic;
    private String tags;

    public Producer(){
        this.producerGroup = "Producer";
        this.topic = "PushTopic";
        this.tags = "push";
    }

    public Producer(String producerGroup, String topic, String tags){
        this.producerGroup = producerGroup;
        this.topic = topic;
        this.tags = tags;
    }

    public void  sendMessage(String message){
        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(NAME_SRV_ADDR);
        try {
            producer.start();

            Message msg = new Message(topic,
                    tags,
                    message.getBytes());

            SendResult result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            producer.shutdown();
        }
    }
}