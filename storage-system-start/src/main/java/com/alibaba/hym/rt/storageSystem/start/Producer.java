package com.alibaba.hym.rt.storageSystem.start;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/16 19:13
 **/

public class Producer {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("messageGroup");
        producer.setNamesrvAddr("127.0.0.1:9876");
        try {
            producer.start();

            Message msg = new Message("messagePush",
                    "push",
                    "Just for test.".getBytes());

            SendResult result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());

            msg = new Message("PushTopic",
                    "push",
                    "Just for test.".getBytes());

            result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());

            msg = new Message("PushTopic",
                    "push",
                    "Just for test.".getBytes());

            result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            producer.shutdown();
        }
    }
}