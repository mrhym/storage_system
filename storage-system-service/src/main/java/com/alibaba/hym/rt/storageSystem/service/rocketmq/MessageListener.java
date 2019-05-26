package com.alibaba.hym.rt.storageSystem.service.rocketmq;

import com.alibaba.hym.rt.storageSystem.service.webSocket.WebSocketServer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/16 16:07
 **/

public class MessageListener implements MessageListenerConcurrently {

   private IMessageProcessor messageProcessor;

   public void setMessageProcessor(IMessageProcessor messageProcessor){
       this.messageProcessor = messageProcessor;
   }

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
       for(MessageExt message : list){
           //业务逻辑
          boolean flag =  messageProcessor.handMessage(message);
          if(!flag){
              return ConsumeConcurrentlyStatus.RECONSUME_LATER;
          }
       }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
