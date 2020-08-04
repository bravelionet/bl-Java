package com.bravelionet.interceptor;

import com.bravelionet.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


/**
 * @Author: Lionet
 * @Date 2020/8/4 23:43
 * @Description 配置springmvc 拦截器, 用于拦截校验用户登录信息及用户资源权限
 * @Param:
 * @Return:
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    /**
     * @Author: Lionet
     * @Date 2020/8/4 23:45
     * @Description Mapper 目标方法之前执行
     * 用户信息存放 session 内, 获取 session中用户信息校验, 是否登录及对应资源权限
     * 1.在这个方法中校验用户请求的url是否在用户的权限范围内
     * 2.取出用户身份信息校验
     * 3.响应客户端
     * @Param:
     * @Return:
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        Object attribute = request.getSession().getAttribute(User.SESSION_USER_KEY);
        if (Objects.isNull(attribute)) {
            writeContent(request,response,"请重新登录");
        }

        User user = (User) attribute;
        //请求的url
        String requestURI = request.getRequestURI();
        if( user.getAuthorities().contains("root") && requestURI.contains("/root/update") || requestURI.contains("/root/query")){
            return true;
        }
        if( user.getAuthorities().contains("user") && requestURI.contains("/root/query")){
            return true;
        }

        writeContent(request,response,"没有权限，拒绝访问");

        return false;

    }

  /*  @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }*/

    /**
     * @Author: Lionet
     * @Date 2020/8/4 23:54
     * @Description 设置响应体
     * @Param:
     * @Return:
     */
    public void writeContent(HttpServletRequest request, HttpServletResponse response, String msg) {
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(msg);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
