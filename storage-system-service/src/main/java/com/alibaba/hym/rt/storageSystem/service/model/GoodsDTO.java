package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/28 12:43
 **/
@Data
public class GoodsDTO {
    private Long barcode;
    private String name;
    private String type;
    private Integer width;
    private Integer height;
    private String describe;
    private Integer unitPrice;
    private String imgPath;
    private Date createdTime;

}
