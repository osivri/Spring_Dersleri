package com.example.services.impl;

import com.example.dto.DtoDepartment;
import com.example.dto.DtoPersonel;
import com.example.models.Personel;
import com.example.repository.PersonelRepository;
import com.example.services.IPersonelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonelServiceImpl implements IPersonelService {

    @Autowired
    private PersonelRepository personelRepository;

    @Override
    public Page<Personel> findAllPageable(Pageable pageable) {
        Page<Personel> page = personelRepository.findAllPageable(pageable);
        return page;
    }

    @Override
    public List<DtoPersonel> toDtoList(List<Personel> personelList) {

        List<DtoPersonel> dtoPersonelList = new ArrayList<>();
        for (Personel personel : personelList) {
            DtoPersonel dtoPersonel = new DtoPersonel();
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(personel, dtoPersonel);
            BeanUtils.copyProperties(personel.getDepartment(), dtoDepartment);
            dtoPersonel.setDepartment(dtoDepartment);
            dtoPersonelList.add(dtoPersonel);
        }
        return dtoPersonelList;
    }
}