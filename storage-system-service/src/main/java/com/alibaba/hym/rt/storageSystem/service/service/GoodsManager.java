package com.alibaba.hym.rt.storageSystem.service.service;

import com.alibaba.hym.rt.storageSystem.service.model.GoodsDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/26 14:10
 **/

public interface GoodsManager {
    public String uploadPic(MultipartFile multipartFile);
    public Integer addGoods(GoodsDTO goodsDTO);
}
