package com.alibaba.hym.rt.storageSystem.web.controller;

import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.dao.ShelvesDAO;
import com.alibaba.hym.rt.storageSystem.service.model.PaginationDO;
import com.alibaba.hym.rt.storageSystem.service.model.ShelvesDO;
import com.alibaba.hym.rt.storageSystem.service.model.ShelvesDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/30 13:22
 **/
@RequestMapping("shelves")
@RestController
public class ShelvesController {
    @Resource
    ShelvesDAO shelvesDAO;

   @RequestMapping("addShelves")
    public Result addStorage(@RequestBody ShelvesDO shelvesDO){
        System.out.println(shelvesDO);
        return Result.success(shelvesDAO.insert(shelvesDO));
   }

   @RequestMapping("countAll")
    public Result  shelvesCount(){
       int storeId = 1;
       return Result.success(shelvesDAO.selectCount(storeId));
   }
   @RequestMapping("shelvesList")
    public Result shelvesInfo(@RequestBody PaginationDO paginationDO){
       //TODO 获取store_id
       int storeId = 1;
       paginationDO.setParam(storeId);
       return Result.success(shelvesDAO.selectAll(paginationDO));
   }

    @RequestMapping("shelvesAll")
    public Result shelvesAll(){
        //TODO 获取store_id
        int storeId = 1;
        return Result.success(shelvesDAO.selectByStoreId(storeId));
    }

    @RequestMapping("updateInfo")
    public Result updateShelvesInfo(@RequestBody ShelvesDTO shelvesDTO){
        //TODO 获取store_id
        return Result.success();
    }
}
