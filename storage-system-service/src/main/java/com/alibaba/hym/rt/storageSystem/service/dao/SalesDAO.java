package com.alibaba.hym.rt.storageSystem.service.dao;

import com.alibaba.hym.rt.storageSystem.service.model.SalesDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/1 13:49
 **/
@Mapper
public interface SalesDAO {
    public SalesDTO selectSalesInfo(Integer barcode);
}
