package com.alibaba.hym.rt.storageSystem.service.dao;

import com.alibaba.hym.rt.storageSystem.service.model.StoreDTO;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/5/2 14:08
 **/

public interface StoreDAO {
    public StoreDTO selectById(Integer id);
}
