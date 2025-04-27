package com.example.controller.impl;


import com.example.entities.RootEntity;

public class RestBaseController {
    public <T>RootEntity<T> ok(T data) {
        return RootEntity.ok(data);
    }

    public <T>RootEntity<T> error(String message) {
        return RootEntity.error(message);
    }
}
