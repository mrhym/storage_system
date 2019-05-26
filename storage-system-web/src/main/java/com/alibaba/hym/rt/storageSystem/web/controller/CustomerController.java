package com.alibaba.hym.rt.storageSystem.web.controller;

import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.dao.CustomerDAO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/29 16:21
 **/
@RequestMapping("customer")
@RestController
public class CustomerController {

    @Resource
    CustomerDAO customerDAO;

    @RequestMapping("/flow")
    public Result customerFlow(@RequestBody Date date){
        return Result.success(customerDAO.selectCustomerFlow(date));
    }

    @RequestMapping("/flowAll")
    public Result customerFlowAll(){
        return Result.success(customerDAO.selectCustomerFlowAll());
    }

}
