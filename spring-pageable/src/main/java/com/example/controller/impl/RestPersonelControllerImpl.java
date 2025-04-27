package com.example.controller.impl;

import com.example.controller.IRestPersonelController;
import com.example.dto.DtoPersonel;
import com.example.models.Personel;
import com.example.services.IPersonelService;
import com.example.util.RestPageableEntity;
import com.example.util.RestPageableRequest;
import com.example.util.RestRootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/personel")
public class RestPersonelControllerImpl extends RestBaseController implements IRestPersonelController {

    @Autowired
    private IPersonelService personelService;

    @GetMapping("/list/pageable")
    @Override
    public RestRootEntity<RestPageableEntity<DtoPersonel>> findAllPageable(RestPageableRequest pageableRequest) {
        Page<Personel> page = personelService.findAllPageable(toPageable(pageableRequest));
        RestPageableEntity<DtoPersonel> pageableResponse = toPageableResponse(page, personelService.toDtoList(page.getContent()));
        return ok(pageableResponse);
    }
}
