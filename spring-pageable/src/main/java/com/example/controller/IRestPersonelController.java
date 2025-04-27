package com.example.controller;

import com.example.dto.DtoPersonel;
import com.example.util.RestPageableEntity;
import com.example.util.RestPageableRequest;
import com.example.util.RestRootEntity;

public interface IRestPersonelController {
    public RestRootEntity<RestPageableEntity<DtoPersonel>> findAllPageable(RestPageableRequest pageableRequest);
}
