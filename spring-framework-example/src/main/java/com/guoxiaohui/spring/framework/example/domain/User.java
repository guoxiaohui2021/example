package com.guoxiaohui.spring.framework.example.domain;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
public class User implements InitializingBean, DisposableBean {

    private String id;

    private String name;

    private Integer age;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct !!!");
        this.setId("01");
        this.setName("@PostConstruct");
        this.setAge(1);
    }


    public void initMethod() {
        System.out.println("initMethod !!!");
        this.setId("03");
        this.setName("BeanDefinitionInitMethodName");
        this.setAge(3);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean#afterPropertiesSet !!!");
        this.setId("02");
        this.setName("InitializingBean#afterPropertiesSet");
        this.setAge(2);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy !!!");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod !!!");
    }

    @Override
    public void destroy() {
        System.out.println("destroy !!!");
    }
}
