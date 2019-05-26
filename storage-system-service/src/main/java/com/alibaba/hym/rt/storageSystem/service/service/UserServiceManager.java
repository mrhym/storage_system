package com.alibaba.hym.rt.storageSystem.service.service;

import com.alibaba.hym.rt.storageSystem.service.model.UserDTO;
import com.alibaba.hym.rt.storageSystem.service.model.UserInfoDTO;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/26 13:29
 **/

public interface UserServiceManager {

    public Integer userLogin(UserDTO userDTO);
    public UserInfoDTO userInfo(String username);
    public Integer userInfoUpdate(UserInfoDTO userInfoDTO);
}
