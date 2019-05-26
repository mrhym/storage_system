package com.alibaba.hym.rt.storageSystem.service.dao;

import com.alibaba.hym.rt.storageSystem.service.model.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/29 14:58
 **/
@Mapper
public interface OrderDAO {
    public Integer selectChargeByOneDay(@Param("date") Date date);
    public Integer selectChargeAmount();
    public Integer selectOrderCount(@Param("date")Date date);
    public Integer selectOrderCountAll();
    public Integer selectOrderCountByStoreId(@Param("id") Integer id);
    public List<OrderDTO> selectAll(@Param("id")Integer id);
}
