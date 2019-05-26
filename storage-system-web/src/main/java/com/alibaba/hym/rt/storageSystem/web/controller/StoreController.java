package com.alibaba.hym.rt.storageSystem.web.controller;

import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.dao.StoreDAO;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/2 14:08
 **/
@RequestMapping("store")
@RestController
public class StoreController {

    @Resource
    StoreDAO storeDAO;
    @RequestMapping("detail")
    public Result storeInfo(Integer storeId){
        return Result.success(storeDAO.selectById(storeId));
    }
}
