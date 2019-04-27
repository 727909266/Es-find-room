package com.huhaoran.esproject.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于角色的登陆入口控制器
 */
public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {
    private final Map<String, String> authEntryPointMap;
    private PathMatcher pathMatcher = new AntPathMatcher();
    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        authEntryPointMap = new HashMap<>();
        //普通用户登陆入口映射
        authEntryPointMap.put("/user/**", "/user/login");
        //管理员登陆入口映射
        authEntryPointMap.put("/admin/**", "/admin/login");
    }

    /**
     * 根据请求跳转到指定的页面，父类是默认使用loginFormUrl
     * @param request
     * @param response
     * @param exception
     * @return
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");
        for(Map.Entry<String, String> authEntry : this.authEntryPointMap.entrySet()) { //使用映射好的路由mapping去找到它的登陆入口
            if(this.pathMatcher.match(authEntry.getKey(), uri)){
                return authEntry.getValue();
            }
        }
        return super.determineUrlToUseForThisRequest(request, response, exception);
    }
}