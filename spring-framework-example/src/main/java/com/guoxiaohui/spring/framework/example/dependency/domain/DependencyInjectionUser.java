package com.guoxiaohui.spring.framework.example.dependency.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class DependencyInjectionUser {


    private String id;

    private String name;

    private Integer age;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DependencyInjectionUser() {
    }

    public DependencyInjectionUser(Integer age) {
        this.age = age;
    }

    @Autowired
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DependencyInjectionUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
