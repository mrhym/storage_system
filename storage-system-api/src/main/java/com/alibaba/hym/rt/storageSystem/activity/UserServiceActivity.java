package com.alibaba.hym.rt.storageSystem.activity;

import com.alibaba.hym.rt.storageSystem.api.UserService;
import com.alibaba.hym.rt.storageSystem.enums.ParamCodeEnums;
import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.model.UserDTO;
import com.alibaba.hym.rt.storageSystem.service.model.UserInfoDTO;
import com.alibaba.hym.rt.storageSystem.service.service.UserServiceManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/1/29 14:23
 **/

@Service
public class UserServiceActivity implements UserService {
    @Resource
    UserServiceManager userServiceManager;

    @Override
    public Result login(UserDTO userDTO) {
        return Optional.ofNullable(userServiceManager.userLogin(userDTO))
                .filter(value -> value >= 1)
                .map(result -> Result.success(result))
                .orElseGet(() -> Result.error(ParamCodeEnums.PARA_ERROR.getCode(), ParamCodeEnums.NULL_RESULT.getMsg()));
    }

    @Override
    public Result userInfo(String username) {
        return Optional.ofNullable(userServiceManager.userInfo(username))
                .map(result -> Result.success(result))
                .orElseGet(() -> Result.error(ParamCodeEnums.PARA_ERROR.getCode(), ParamCodeEnums.NULL_RESULT.getMsg()));

    }

    @Override
    public Result updateInfo(UserInfoDTO userInfoDTO) {
        return Optional.ofNullable(userServiceManager.userInfoUpdate(userInfoDTO))
                .filter(value-> value == 1)
                .map(result -> Result.success(result))
                .orElseGet(() -> Result.error(ParamCodeEnums.PARA_ERROR.getCode(), ParamCodeEnums.NULL_RESULT.getMsg()));

    }

}
