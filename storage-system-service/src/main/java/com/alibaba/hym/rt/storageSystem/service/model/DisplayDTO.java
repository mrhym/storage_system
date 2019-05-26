package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/20 16:28
 **/

@Data
public class DisplayDTO {
    private Integer id;
    private String username;
    private Integer storeId;
    private String shelvesCode;
    private Integer laminateNum;
    private Integer barcode;
    private String goodsName;
}
