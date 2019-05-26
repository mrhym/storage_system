package com.alibaba.hym.rt.storageSystem.web.shiro;

import com.alibaba.hym.rt.storageSystem.service.cahe.LoginCacheService;
import com.alibaba.hym.rt.storageSystem.web.shiro.bean.JwtToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/1/28 19:07
 */
@Service
public class LoginRealm extends AuthorizingRealm {

    @Resource
    private LoginCacheService loginCacheService;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String username =  loginCacheService.getUsernameByToken(principals.toString());
         SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        RoleDTO roleDTO = roleServiceManager.getRoleByUsername(username);
//        if(roleDTO != null){
//            Set<String> permission = new HashSet<>(roleDTO.getPermissions());
//            simpleAuthorizationInfo.addStringPermissions(permission);
//        }
         return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        String username = loginCacheService.getUsernameByToken(token );
        // 解密获得username，用于和数据库进行对比
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}