package com.huhaoran.esproject.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
//@EnableGlobalMethodSecurity 加上会报错
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * HTTP权限控制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //资源访问权限
        http.authorizeRequests()
                .antMatchers("/admin/login").permitAll() //所有用户都可以点这个页面  管理员登陆入口
                .antMatchers("/static/**").permitAll() //静态资源允许任何权限都可以访问
                .antMatchers("/user/login").permitAll() //用户登陆入口
                .antMatchers("/admin/**").hasRole("ADMIN") //admin开头的需要管理员权限
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER") //用户相关的需要有用户权限或者管理员权限
                .antMatchers("/api/user/**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginProcessingUrl("/login") //配置角色登陆处理入口
                .and();
    }
}
