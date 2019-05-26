//package com.alibaba.hym.rt.storageSystem.web.config;
//
//
//import com.google.common.collect.Maps;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
//import org.apache.shiro.mgt.DefaultSubjectDAO;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//
//import javax.servlet.Filter;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//
///**
// * @Author MonkeyKing
// * @Description: TODO
// * @Date: 2019/1/28 19:07
//
//*/
//
//
//
//
//@Configuration
//@Slf4j
//public class ShiroConfig {
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//
//        // 必须设置 SecurityManager
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
//        shiroFilterFactoryBean.setLoginUrl("/notLogin");
//        // 设置无权限时跳转的 url;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/401");
//
//        // 添加自己的过滤器并且取名为jwt
//        Map<String, Filter> filterMap = Maps.newHashMap();
//        filterMap.put("jwt", new JwtFilter());
//        shiroFilterFactoryBean.setFilters(filterMap);
//
//        // 设置拦截器
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
////        //游客，开发权限
////        filterChainDefinitionMap.put("/guest/**", "anon");
////        //用户，需要角色权限 “user”
////        filterChainDefinitionMap.put("/user/**", "roles[user]");
////        //管理员，需要角色权限 “admin”
////        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
//        //开放登陆接口
//        filterChainDefinitionMap.put("/admin/login", "anon");
//        //开放登陆接口
//        filterChainDefinitionMap.put("/login", "anon");
//        // 访问401和404页面不通过我们的Filter
//        filterChainDefinitionMap.put("/401", "anon");
//        //其余接口一律拦截
//        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
//        filterChainDefinitionMap.put("/**", "jwt");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean("securityManager")
//    public DefaultWebSecurityManager getManager(LoginRealm realm) {
//        DefaultWebSecurityManager activity = new DefaultWebSecurityManager();
//        // 使用自己的realm
//        activity.setRealm(realm);
//
//        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
//        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
//        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
//        activity.setSubjectDAO(subjectDAO);
//
//        return activity;
//    }
//
//
///**
//     * 自定义身份认证 realm;
//     * <p>
//     * 必须写这个类，
//     * 并加上 @Bean 注解，
//     * 目的是注入 CustomRealm，
//     * <p>
//     * 否则会影响 CustomRealm类
//     * 中其他类的依赖注入
//     */
//
////    @Bean("loginRealm")
////    public LoginRealm loginRealm() {
////        return new LoginRealm();
////    }
//
///**
//  *下面的代码是添加注解支持
//**/
//
//    @Bean
//    @DependsOn("lifecycleBeanPostProcessor")
//
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
//        // https://zhuanlan.zhihu.com/p/29161098
//        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
//        return defaultAdvisorAutoProxyCreator;
//    }
//
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(securityManager);
//        return advisor;
//    }
//}
//
//
