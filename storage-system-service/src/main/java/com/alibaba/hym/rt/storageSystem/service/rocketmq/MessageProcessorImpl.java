package com.alibaba.hym.rt.storageSystem.service.rocketmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.hym.rt.storageSystem.service.model.MessageDTO;
import com.alibaba.hym.rt.storageSystem.service.service.MqMessageServiceManager;
import com.alibaba.hym.rt.storageSystem.service.webSocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/16 16:09
 **/
@Slf4j
@Service
public class MessageProcessorImpl implements IMessageProcessor {

    @Resource
    MqMessageServiceManager messageServiceManager;

    @Override
    public boolean handMessage(MessageExt message) {
        try{
            MessageDTO messageDTO = new MessageDTO();
            messageDTO.setTopic(message.getTopic());
            messageDTO.setMessageId(message.getMsgId());
            messageDTO.setTags(message.getTags());
            messageDTO.setKeys(message.getKeys());
            String body = new String(message.getBody(),"UTF-8");
            messageDTO.setBody(body);
            messageDTO.setCreatedTime(new Date());

            Integer result = messageServiceManager.saveMQMessageInfo(messageDTO);
            if(result == null || result < 1){
                log.info("save MqMessage is error , return result is : {}",result);
            }
            WebSocketServer.sendInfo(body);
            log.info("handMessage(),insert messageDTO info is  :{}",JSON.toJSONString(messageDTO));
        }catch (Exception e){
            log.info("IMessageProcessor logic is error : {}",e);
            return false;
        }
        return true;
    }
}
