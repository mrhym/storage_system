package com.alibaba.hym.rt.storageSystem.web.controller;

import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.dao.DisplayGoodsDAO;
import com.alibaba.hym.rt.storageSystem.service.model.DisplayDO;
import com.alibaba.hym.rt.storageSystem.service.model.DisplayDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/20 16:26
 **/
@RequestMapping("display")
@RestController
public class DisplayGoodsController {

    @Resource
    DisplayGoodsDAO displayGoodsDAO;

    @RequestMapping("save")
    public Result saveDisplay(@RequestBody DisplayDTO displayDTO){
        DisplayDO displayDO = new DisplayDO();
        BeanUtils.copyProperties(displayDTO,displayDO);

        //TODO 获取 用户名,店铺ID
        displayDO.setUsername("123");
        displayDO.setStoreId(1);
        System.out.println(displayDO);
        return Result.success(displayGoodsDAO.insert(displayDO));
    }

    @RequestMapping("show")
    public Result showDisplay(){
        //TODO 获取 店铺ID
       int storeId = 1;
       return Result.success(displayGoodsDAO.selectByStoreId(storeId));
    }

    @RequestMapping("update")
    public Result updateDisplayLocal(@RequestBody DisplayDO displayDO){
        System.out.println(displayDO);
        return Result.success(displayGoodsDAO.update(displayDO));
    }
}
