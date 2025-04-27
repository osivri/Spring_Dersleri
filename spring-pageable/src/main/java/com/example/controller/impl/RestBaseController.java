package com.example.controller.impl;

import com.example.util.PagerUtil;
import com.example.util.RestPageableEntity;
import com.example.util.RestPageableRequest;
import com.example.util.RestRootEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RestBaseController {
    public Pageable toPageable(RestPageableRequest pageableRequest) {
        return PagerUtil.toPageable(pageableRequest);
    }

    public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content){
        return PagerUtil.toPageableResponse(page, content);
    }

    public <T> RestRootEntity<T> ok(T payload){
        return RestRootEntity.ok(payload);
    }

}
