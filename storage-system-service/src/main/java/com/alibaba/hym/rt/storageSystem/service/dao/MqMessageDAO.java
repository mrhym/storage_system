package com.alibaba.hym.rt.storageSystem.service.dao;

import com.alibaba.hym.rt.storageSystem.service.model.MessageDTO;
import org.apache.ibatis.annotations.Param;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/17 13:20
 **/

public interface MqMessageDAO {
    public Integer insert(@Param("message") MessageDTO messageDTO);
}
