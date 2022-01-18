package com.guoxiaohui.java.example.spi;

import com.guoxiaohui.java.example.spi.i.MyService;

import java.util.ServiceLoader;

/**
 * SPI:Service Provider Interface
 * Java提供的 服务注册与发现机制   作用：通过解耦服务提供者与服务使用者，帮助实现模块化、组件化
 *
 * @author guoxiaohui
 */
public class ServiceLoaderDemo {

    /**
     * ServiceLoader 使用步骤
     * 步骤1：服务使用者    定义服务接口
     * 步骤2：服务提供者    实现服务接口
     * 步骤3：注册实现类到配置文件
     * 步骤4：加载服务；使用ServiceLoader遍历实现类
     */
    public static void main(String[] args) {
        ServiceLoader.load(MyService.class).forEach(MyService::exec);
    }

}
