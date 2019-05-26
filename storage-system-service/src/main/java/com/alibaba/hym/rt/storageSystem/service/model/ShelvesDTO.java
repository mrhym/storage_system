package com.alibaba.hym.rt.storageSystem.service.model;

import lombok.Data;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/30 13:23
 **/
@Data
public class ShelvesDTO {
    private Integer storeId;
    private String shelvesCode;
    private Integer width;
    private Integer height;
    private Integer laminateNum;
    private String area;
}
