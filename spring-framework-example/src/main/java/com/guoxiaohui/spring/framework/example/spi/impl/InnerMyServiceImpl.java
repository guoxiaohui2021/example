package com.guoxiaohui.spring.framework.example.spi.impl;

import com.guoxiaohui.spring.framework.example.spi.MyService;

public class InnerMyServiceImpl implements MyService {

    @Override
    public void exec() {
        System.out.println("00-useServiceLoaderFactoryBean");
    }
}
