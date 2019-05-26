package com.alibaba.hym.rt.storageSystem.service.cahe.impl;

import com.alibaba.hym.rt.storageSystem.service.cahe.LoginCacheService;
import com.alibaba.hym.rt.storageSystem.service.utils.RedisUtil;
import com.alibaba.hym.rt.storageSystem.service.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/2/25 21:30
 **/
@Slf4j
@Service
public class LoginCacheServiceImpl implements LoginCacheService {

    @Resource
    RedisUtil redisUtil;

    private static final String  AUTHORIZATION = "Authorization";

    @Override
    public String creatCacheAndToken(String username) {
        String token = TokenUtils.createToken(username);
        if (StringUtils.isEmpty(token)) {
            log.info("createToken is error , the result is :{}", token);
            return null;
        }
        String flag = redisUtil.set(token, username);

        if (StringUtils.isEmpty(flag)) {
            log.info("redis put token and username is null");
            return null;
        }
        log.info("redis put token: {}, and username: {}. result is : {}", token, username, flag);
        return token;
    }

    @Override
    public String getUsername() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
       String token = request.getHeader(AUTHORIZATION);

       if(StringUtils.isEmpty(token)){
           log.info("get username is error,because token is : {}",token);
       }
        return redisUtil.get(token);
    }

    @Override
    public String getUsernameByToken(String token) {
        return redisUtil.get(token);
    }
}
