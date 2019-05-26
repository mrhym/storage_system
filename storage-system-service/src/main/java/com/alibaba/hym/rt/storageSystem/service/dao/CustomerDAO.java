package com.alibaba.hym.rt.storageSystem.service.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/29 16:22
 **/

public interface CustomerDAO {
    public Integer selectCustomerFlowAll();
    public Integer selectCustomerFlow(@Param("date") Date date);
}
