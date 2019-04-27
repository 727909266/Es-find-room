package com.huhaoran.esproject.config;

import com.huhaoran.esproject.security.AuthProvider;
import com.huhaoran.esproject.security.LoginAuthFailHandler;
import com.huhaoran.esproject.security.LoginUrlEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
                .failureHandler(authFailHandler())
                .and()
                .logout()
                .logoutUrl("/logout") //处理Url使用原生
                .logoutSuccessUrl("/logout/page") //处理成功使用自定义的页面
                .deleteCookies("JSESSIONID")//登出成功删除cookies JSESSIONID
                .invalidateHttpSession(true) //session会话失效
                .and()//结束
                .exceptionHandling()
                .authenticationEntryPoint(urlEntryPoint())
                .accessDeniedPage("/403"); //无权访问的提示页面
        http.csrf().disable(); //csrf防御策略，方便开发，先关掉
        http.headers().frameOptions().sameOrigin();
    }

    /**
     * 自定义认证策略
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider()).eraseCredentials(true);
    }

    @Bean
    public AuthProvider authProvider() {
        return new AuthProvider();
    }

    @Bean
    public LoginUrlEntryPoint urlEntryPoint() {
        return new LoginUrlEntryPoint("/user/login");
    }


    @Bean
    public LoginAuthFailHandler authFailHandler() {
        return new LoginAuthFailHandler(urlEntryPoint());
    }
/*
    @Bean
    public AuthenticationManager authenticationManager() {
        AuthenticationManager authenticationManager = null;
        try {
            authenticationManager =  super.authenticationManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticationManager;
    }

    @Bean
    public AuthFilter authFilter() {
        AuthFilter authFilter = new AuthFilter();
        authFilter.setAuthenticationManager(authenticationManager());
        authFilter.setAuthenticationFailureHandler(authFailHandler());
        return authFilter;
    }
    */
}
