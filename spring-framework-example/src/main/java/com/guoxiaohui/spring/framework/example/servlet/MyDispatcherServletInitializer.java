package com.guoxiaohui.spring.framework.example.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 配置root上下文,如Jpa数据源等等的配置
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * 配置dispatcher servlet，如果在root config指定了该转发规则就可以忽略
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    /**
     * 指定开始被servlet处理的url,配置从/开始
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
