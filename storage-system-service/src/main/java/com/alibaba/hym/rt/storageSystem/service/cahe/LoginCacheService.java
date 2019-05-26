package com.alibaba.hym.rt.storageSystem.service.cahe;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/2/25 21:29
 **/

public interface LoginCacheService {
    public String creatCacheAndToken(String username);
    public String getUsername();
    public String getUsernameByToken(String token);
}
