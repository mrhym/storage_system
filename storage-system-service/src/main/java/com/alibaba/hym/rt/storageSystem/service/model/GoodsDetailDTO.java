package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/2 14:56
 **/
@Data
public class GoodsDetailDTO {
    private Integer storeId;
    private  Integer orderId;
    private  String barcode;
    private String goodsName;
    private Integer goodsNumber;
    private Integer unitPrice;
}
