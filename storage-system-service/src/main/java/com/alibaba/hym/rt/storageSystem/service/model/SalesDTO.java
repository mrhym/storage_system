package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/1 13:50
 **/
@Data
public class SalesDTO {
    private Integer barcode;
    private Integer salesAmount;
    private Integer salesVolume;
    private Integer unitPrice;
}
