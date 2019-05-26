package com.alibaba.hym.rt.storageSystem.service.service.impl;

import com.alibaba.hym.rt.storageSystem.service.dao.GoodsDAO;
import com.alibaba.hym.rt.storageSystem.service.model.GoodsDO;
import com.alibaba.hym.rt.storageSystem.service.model.GoodsDTO;
import com.alibaba.hym.rt.storageSystem.service.service.GoodsManager;
import com.alibaba.hym.rt.storageSystem.service.utils.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/26 14:10
 **/
@Service
public class GoodsManagerImpl implements GoodsManager {

    @Value("${file.save.basePath}")
    private  String basePath;

    @Value("${file.save.sonPath}")
    private  String sonPath;

    @Resource
    GoodsDAO goodsDAO;

    @Override
    public String uploadPic(MultipartFile multipartFile) {
        String fileUrl = null;
        try {
            if (FileUtil.isImage(multipartFile)) {
                if (FileUtil.checkFileParam(multipartFile)) {
                    fileUrl = FileUtil.saveFile(basePath+sonPath,multipartFile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return Optional.ofNullable(fileUrl)
                .orElse(null);
    }

    @Override
    public Integer addGoods(GoodsDTO goodsDTO) {
        GoodsDO goodsDO = new GoodsDO();
        BeanUtils.copyProperties(goodsDTO,goodsDO);
        goodsDO.setCreatedTime(new Date());
        goodsDO.setModifiedTime(new Date());
        System.out.println(goodsDO);
        return goodsDAO.insert(goodsDO);
    }
}
