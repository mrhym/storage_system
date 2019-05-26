package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/17 13:09
 **/
@Data
public class MessageDTO {
    private String topic;
    private String messageId;
    private String tags;
    private String keys;
    private String Body;
    private Date createdTime;
}
