package com.guoxiaohui.spring.framework.example.dependency.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FieldDependencyInjectionUser {

    @Autowired
    @Qualifier("stringId")
    private String id;

    @Autowired
    @Qualifier("stringName")
    private String name;

    @Autowired
    private Integer age;

    @Override
    public String toString() {
        return "FieldDependencyInjectionUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
