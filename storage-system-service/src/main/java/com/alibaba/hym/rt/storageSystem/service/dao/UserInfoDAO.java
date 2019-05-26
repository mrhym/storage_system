package com.alibaba.hym.rt.storageSystem.service.dao;

import com.alibaba.hym.rt.storageSystem.service.model.UserInfoDO;
import com.alibaba.hym.rt.storageSystem.service.model.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/8 12:21
 **/
@Mapper
public interface UserInfoDAO {
    public UserInfoDTO selectByPrimaryKey(String username);
    public Integer update(@Param("info") UserInfoDO userInfoDO);
}
