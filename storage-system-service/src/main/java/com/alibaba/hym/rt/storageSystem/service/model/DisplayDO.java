package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/20 16:31
 **/
@Data
public class DisplayDO {
    private Integer id;
    private String username;
    private Integer storeId;
    private String shelvesCode;
    private Integer laminateNum;
    private Integer barcode;
    private String goodsName;
}
