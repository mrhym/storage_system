package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/2 14:08
 **/
@Data
public class StoreDTO {
    private Integer storeId;
    private String storeName;
    private String address;
    private Date createdTime;
}
