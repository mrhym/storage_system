package com.alibaba.hym.rt.storageSystem.service.service.impl;

import com.alibaba.hym.rt.storageSystem.service.dao.UserDAO;
import com.alibaba.hym.rt.storageSystem.service.dao.UserInfoDAO;
import com.alibaba.hym.rt.storageSystem.service.model.UserDO;
import com.alibaba.hym.rt.storageSystem.service.model.UserDTO;
import com.alibaba.hym.rt.storageSystem.service.model.UserInfoDO;
import com.alibaba.hym.rt.storageSystem.service.model.UserInfoDTO;
import com.alibaba.hym.rt.storageSystem.service.service.UserServiceManager;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/11 14:24
 **/
@Service
public class UserServiceManagerImpl implements UserServiceManager {

    @Resource
    UserDAO userDAO;

    @Resource
    UserInfoDAO userInfoDAO;

    @Override
    public Integer userLogin(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO,userDO);
        return  userDAO.login(userDO);
    }

    @Override
    public UserInfoDTO userInfo(String username) {
        return userInfoDAO.selectByPrimaryKey(username);
    }

    @Override
    public Integer userInfoUpdate(UserInfoDTO userInfoDTO) {
        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(userInfoDTO,userInfoDO);
        return userInfoDAO.update(userInfoDO);
    }
}
