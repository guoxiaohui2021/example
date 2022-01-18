package com.guoxiaohui.spring.framework.example.domain;

import lombok.Data;

@Data
public class User {

    private String id;

    private String name;

    private Integer age;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
