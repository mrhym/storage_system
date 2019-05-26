package com.alibaba.hym.rt.storageSystem.web.controller;

import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.dao.OrderDAO;
import com.alibaba.hym.rt.storageSystem.service.dao.OrderDetailDAO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/29 14:13
 **/
@RequestMapping("order")
@RestController
public class OrderController {

    @Resource
    OrderDAO orderDAO;

    @Resource
    OrderDetailDAO orderDetailDAO;


    @RequestMapping("/count")
    public Result orderCount(@RequestBody Date date){
        return Result.success(orderDAO.selectOrderCount(date));
    }

    @RequestMapping("/countAll")
    public Result orderCountAll(){
        //TODO 缓存获取storeId
        Integer storeId = 1;
        return Result.success(orderDAO.selectOrderCountByStoreId(1));
    }

    @RequestMapping("orderGoods")
    public Result orderGoods(Integer orderId){

        //TODO 缓存获取storeId
        Integer storeId = 1;
        System.out.println(orderId);
        return Result.success(orderDetailDAO.selectByOrderId(storeId,orderId));
    }

    @RequestMapping("/orderList")
    public Result  orderList(){

        //TODO 缓存获取storeId
        Integer storeId = 1;
        return Result.success(orderDAO.selectAll(storeId));
    }

    @RequestMapping("/charge")
    public Result chargeByOneDay(@RequestBody Date date){
        return Optional.ofNullable(orderDAO.selectChargeByOneDay(date))
                .map(result->Result.success(result))
                .orElseGet(()->Result.success(0));
    }

    @RequestMapping("/chargeAll")
    public Result chargeAmount(){
        return Result.success(orderDAO.selectChargeAmount());
    }
}
