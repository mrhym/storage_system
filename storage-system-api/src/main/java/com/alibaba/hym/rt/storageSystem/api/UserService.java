package com.alibaba.hym.rt.storageSystem.api;

import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.model.UserDTO;
import com.alibaba.hym.rt.storageSystem.service.model.UserInfoDTO;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/1/29 14:17
 **/

public interface UserService {
    public Result login(UserDTO userDTO);
    public Result userInfo(String username);
    public Result updateInfo(UserInfoDTO userInfoDTO);
}
