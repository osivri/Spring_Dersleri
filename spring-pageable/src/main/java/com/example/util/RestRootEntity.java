package com.example.util;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RestRootEntity<T> {
    private Integer status;
    private  T payload;
    private  String errorMessage;

    public static <T> RestRootEntity<T> ok(T payload){
        RestRootEntity<T> rootEntity = new RestRootEntity<>();
        rootEntity.setStatus(HttpStatus.OK.value());
        rootEntity.setErrorMessage(null);
        rootEntity.setPayload(payload);
        return rootEntity;
    }
}
