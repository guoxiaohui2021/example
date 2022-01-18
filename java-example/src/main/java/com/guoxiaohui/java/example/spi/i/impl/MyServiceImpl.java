package com.guoxiaohui.java.example.spi.i.impl;

import com.guoxiaohui.java.example.spi.i.MyService;

/**
 * 该服务提供者不需要在当前项目，只是为了简单演示
 *
 * @author guoxiaohui
 */
public class MyServiceImpl implements MyService {

    public void exec() {
        System.out.println("MyServiceImpl exec method!!!");
    }
}
