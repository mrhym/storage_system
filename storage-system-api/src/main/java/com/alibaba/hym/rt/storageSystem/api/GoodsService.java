package com.alibaba.hym.rt.storageSystem.api;

import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.model.GoodsDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/26 14:08
 **/

public interface GoodsService {
   public Result uploadPic(MultipartFile multipartFile);
   public Result addGoods(GoodsDTO goodsDTO);
}
