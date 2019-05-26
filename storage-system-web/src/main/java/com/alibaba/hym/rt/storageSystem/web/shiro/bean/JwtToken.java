package com.alibaba.hym.rt.storageSystem.web.shiro.bean;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/1/28 19:20
 **/

import org.apache.shiro.authc.AuthenticationToken;

public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}