package com.alibaba.hym.rt.storageSystem.service.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/2/25 17:29
 **/

public class RequestStatusUtil {

    private static HttpServletRequest request = null;
    private static final String AUTHORIZATION = "Authorization";

    static {
        request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
    }

    public static String getToken() {
        String token = request.getHeader("AUTHORIZATION");
        return token;
    }
}
