package com.alibaba.hym.rt.storageSystem.service.dao;

import com.alibaba.hym.rt.storageSystem.service.model.PaginationDO;
import com.alibaba.hym.rt.storageSystem.service.model.ShelvesDO;
import com.alibaba.hym.rt.storageSystem.service.model.ShelvesDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/30 13:25
 **/
@Mapper
public interface ShelvesDAO {
    public Integer insert(@Param("shelves") ShelvesDO shelvesDO);
    public Integer selectCount(Integer storeId);
    public List<ShelvesDTO> selectByStoreId(int storeId);
    public List<ShelvesDTO> selectAll(@Param("query") PaginationDO<Integer> paginationDO);
}
