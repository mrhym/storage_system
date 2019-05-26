package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/28 12:44
 **/
@Data
public class GoodsDO {
    private Long barcode;
    private String name;
    private String type;
    private Integer width;
    private Integer height;
    private String describe;
    private String imgPath;
    private Date createdTime;
    private Date modifiedTime;
}
