package com.alibaba.hym.rt.storageSystem.web.controller;

import com.alibaba.hym.rt.storageSystem.api.UserService;
import com.alibaba.hym.rt.storageSystem.enums.ParamCodeEnums;
import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.cahe.LoginCacheService;
import com.alibaba.hym.rt.storageSystem.service.model.UserDTO;
import com.alibaba.hym.rt.storageSystem.service.model.UserInfoDTO;
import com.alibaba.hym.rt.storageSystem.service.utils.RedisUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/22 14:07
 **/
@RequestMapping("user")
@RestController
public class UserController {
    @Resource
    UserService userService;

    @Resource
    LoginCacheService loginCacheService;

    @Resource
    RedisUtil redisUtil;

    @RequestMapping("/login")
    public Result userLogin(@RequestBody UserDTO userDTO) {
        if (userDTO == null || StringUtils.isEmpty(userDTO.getUsername())
                || StringUtils.isEmpty(userDTO.getPassword())) {
            return Result.error(ParamCodeEnums.PARA_ERROR.getCode(), ParamCodeEnums.PARA_ERROR.getMsg());
        }
        Result result = userService.login(userDTO);
        if (result.getData() != null) {
            String token = loginCacheService.creatCacheAndToken(userDTO.getUsername());
            if (StringUtils.isEmpty(token)) {
                return Result.error(ParamCodeEnums.TOKEN_ERROR.getCode(), ParamCodeEnums.TOKEN_ERROR.getMsg());
            }
            return Result.success(token);
        }
        return Result.error(ParamCodeEnums.LOGIN_ERROR.getCode(), ParamCodeEnums.LOGIN_ERROR.getMsg());
    }

    @RequestMapping("getUsername")
    public Result getUsername(){
        return Result.success(loginCacheService.getUsername());
    }


    @RequestMapping("/info")
    public Result getUserInfo(){
        String username = loginCacheService.getUsername();
        return Result.success(userService.userInfo(username));
    }

    @RequestMapping("/updateProfile")
    public Result updateProfile(@RequestBody UserInfoDTO userInfoDTO){
        return Result.success(userService.updateInfo(userInfoDTO));
    }
}
