package com.alibaba.hym.rt.storageSystem.service.dao;

import com.alibaba.hym.rt.storageSystem.service.model.UserDO;
import com.alibaba.hym.rt.storageSystem.service.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/26 12:10
 **/
@Mapper
public interface UserDAO {
    public Integer login(@Param("user") UserDO userDO);
}
