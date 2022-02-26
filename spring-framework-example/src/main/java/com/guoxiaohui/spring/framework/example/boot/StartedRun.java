package com.guoxiaohui.spring.framework.example.boot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;

/**
 * {@link org.springframework.boot.CommandLineRunner}
 * {@link org.springframework.boot.ApplicationRunner}
 * 可以使用{@link org.springframework.core.annotation.Order} 指定执行顺序
 *
 * @author guoxiaohui
 */
public class StartedRun implements ApplicationRunner, CommandLineRunner {

    /**
     * ApplicationArguments
     * ApplicationRunner
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    /**
     * CommandLineRunner接口以字符串数组的形式
     * CommandLineRunner
     */
    @Override
    public void run(String... args) throws Exception {

    }
}
