package com.alibaba.hym.rt.storageSystem.service.dao;

import com.alibaba.hym.rt.storageSystem.service.model.GoodsDTO;
import com.alibaba.hym.rt.storageSystem.service.model.GoodsDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/2 14:55
 **/
@Mapper
public interface OrderDetailDAO {
    public List<GoodsDetailDTO> selectByOrderId(Integer storeId, Integer orderId);
}
