package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/2 13:00
 **/
@Data
public class OrderDTO {
    private Integer storeId;
    private Integer orderId;
    private String username;
    private Integer charge;
    private String status;
    private Date createdTime;
}
