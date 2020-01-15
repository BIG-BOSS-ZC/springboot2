package com.bailiban.springboot.intercepter;

import com.bailiban.springboot.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.取出URI
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        //2.判断是否是登录/注册页面，其他页面则需要拦截
        if(requestURI.contains("login")||requestURI.contains("register")){
            return true;
        }
        //如果登录了就不拦截
        User user=(User) request.getSession().getAttribute("user");
        if(user!=null){
            return true;
        }
        //3.重定向
        response.sendRedirect("/user/login");
        return false;
        //4.配置xml
    }
}
