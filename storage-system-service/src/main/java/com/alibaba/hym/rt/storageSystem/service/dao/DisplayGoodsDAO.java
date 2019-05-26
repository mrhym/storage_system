package com.alibaba.hym.rt.storageSystem.service.dao;

import com.alibaba.hym.rt.storageSystem.service.model.DisplayDO;
import com.alibaba.hym.rt.storageSystem.service.model.DisplayDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/20 16:30
 **/
@Mapper
public interface DisplayGoodsDAO {
    public Integer insert(@Param("display") DisplayDO displayDO);
    public List<DisplayDTO> selectByStoreId(int storeId);
    public Integer update(@Param("display")DisplayDO displayDO);
}
