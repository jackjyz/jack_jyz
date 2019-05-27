package com.zzti.bookstore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这是一个登陆拦截器
 * 进行登陆拦截
 */
@Configuration
public class LoginHandleInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入LoginInterceptor拦截器==============");
        String basePath = request.getContextPath();
        String path = request.getRequestURI();
        logger.info("basePath:" + basePath);
        logger.info("path:" + path);
        logger.info("userkey:" + request.getSession().getAttribute("userkey"));
        if (request.getSession().getAttribute("username") == null) {
            logger.info("尚未登录，跳转到登录界面");
            response.setHeader("Content-Type", "text/html;charset=UTF-8");
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        logger.info("已登录，放行！");
        return true;
    }
}
