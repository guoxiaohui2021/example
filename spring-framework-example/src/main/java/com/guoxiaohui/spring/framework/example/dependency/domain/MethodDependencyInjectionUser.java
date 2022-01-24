package com.guoxiaohui.spring.framework.example.dependency.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MethodDependencyInjectionUser {

    private String id;

    private String name;

    private Integer age;

    @Autowired
    @Qualifier("stringId")
    private void idInject(String id) {
        this.id = id;
    }

    @Autowired
    @Qualifier("stringName")
    private void nameInject(String name) {
        this.name = name;
    }

    @Autowired
    private void ageInject(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MethodDependencyInjectionUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
