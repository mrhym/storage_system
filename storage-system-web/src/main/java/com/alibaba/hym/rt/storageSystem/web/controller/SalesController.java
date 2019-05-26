package com.alibaba.hym.rt.storageSystem.web.controller;

import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.dao.SalesDAO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/1 13:46
 **/
@RequestMapping("sales")
@RestController
public class SalesController {

    @Resource
    SalesDAO salesDAO;

    @RequestMapping("salesInfo")
    public Result SalesVolume(@RequestBody Integer barcode){
        return Result.success(salesDAO.selectSalesInfo(barcode));
    }
}
