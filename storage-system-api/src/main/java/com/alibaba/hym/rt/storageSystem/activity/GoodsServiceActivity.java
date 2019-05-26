package com.alibaba.hym.rt.storageSystem.activity;

import com.alibaba.hym.rt.storageSystem.api.GoodsService;
import com.alibaba.hym.rt.storageSystem.enums.ParamCodeEnums;
import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.model.GoodsDTO;
import com.alibaba.hym.rt.storageSystem.service.service.GoodsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/26 14:09
 **/
@Service
public class GoodsServiceActivity implements GoodsService {

    @Resource
    GoodsManager goodsManager;

    @Override
    public Result uploadPic(MultipartFile multipartFile) {
        String fileUrl = goodsManager.uploadPic(multipartFile);
        return Optional.ofNullable(fileUrl)
                .map(result -> Result.success(fileUrl))
                .orElse(Result.error(ParamCodeEnums.UPLOAD_ERROR.getCode(), ParamCodeEnums.UPLOAD_ERROR.getMsg()));

    }

    @Override
    public Result addGoods(GoodsDTO goodsDTO) {
        return Optional.ofNullable(goodsManager.addGoods(goodsDTO))
                .filter(value->value >= 1)
                .map(result -> Result.success())
                .orElse(Result.error(ParamCodeEnums.ERROR.getCode(), ParamCodeEnums.ERROR.getMsg()));
    }
}
