package com.example.services;

import com.example.dto.DtoPersonel;
import com.example.models.Personel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonelService {
    public Page<Personel> findAllPageable(Pageable pageable);
    List<DtoPersonel> toDtoList(List<Personel> personelList);

}
