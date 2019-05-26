package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/8 12:21
 **/
@Data
public class UserInfoDTO {
    private String username;
    private String name;
    private Integer storeId;
    private Date  createdTime;
    private String profileImg;
}
