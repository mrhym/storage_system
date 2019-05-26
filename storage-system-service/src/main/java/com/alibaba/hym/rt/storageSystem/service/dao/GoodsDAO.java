package com.alibaba.hym.rt.storageSystem.service.dao;

import com.alibaba.hym.rt.storageSystem.service.model.GoodsDO;
import com.alibaba.hym.rt.storageSystem.service.model.GoodsDTO;
import com.alibaba.hym.rt.storageSystem.service.model.PaginationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/28 12:50
 **/
@Mapper
public interface GoodsDAO {
    public  Integer selectById();
    public  List<GoodsDTO> selectAll();
    public  Integer insert(@Param("goods")GoodsDO goodsDO);
    public List<GoodsDTO> selectByPage(@Param("query") PaginationDO<Integer> paginationDO);
}
