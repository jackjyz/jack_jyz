package com.zzti.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginHandleInterceptor loginHandleInterceptor;
    /**
     * 浏览器发送"/login"请求，来到login页面
     * static文件夹下的资源全部不拦截
     */
    final String[] notLoginInterceptPaths = {"/static/**", "/login", "/error/**", "/", "/login.html", "register", "/toRegister","/register"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 这里添加多个拦截器
        // 登录拦截器
        /**
         * 先拦截所有请求
         * 在将登陆请求放行
         */
        registry.addInterceptor(loginHandleInterceptor).addPathPatterns("/**")
                .excludePathPatterns(notLoginInterceptPaths);
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
    /**
     * 配置不需要经过controller就跳转到登录页面
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("register").setViewName("register");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/toRegister").setViewName("toRegister");
    }
    /***
     * addResourceLocations指的是文件放置的目录，addResoureHandler指的是对外暴露的访问路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 排除静态资源拦截
         * 在Spring boot2.0以后排除静态资源拦截必须要
         * 在2.0以后只要配置了@Configuration系统就会默认拦截静态资源(css,js等)
         */
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
