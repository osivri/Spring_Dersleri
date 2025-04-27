package com.example.services.impl;

import com.example.dto.DtoAddress;
import com.example.dto.DtoGalerist;
import com.example.dto.DtoGaleristIU;
import com.example.exception.BaseException;
import com.example.exception.ErrorMessage;
import com.example.exception.MessageType;
import com.example.models.Address;
import com.example.models.Gallerist;
import com.example.repository.AddressRepository;
import com.example.repository.GaleristRepository;
import com.example.services.IGalleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristServiceImpl implements IGalleristService {

    @Autowired
    private GaleristRepository galleristRepository;

    @Autowired
    private AddressRepository addressRepository;

    private Gallerist createGallerist(DtoGaleristIU dtoGaleristIU) {
        Optional<Address> addressOpt = addressRepository.findById(dtoGaleristIU.getAddressId());

        if (addressOpt.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGaleristIU.getAddressId().toString()));
        }
        Gallerist gallerist = new Gallerist();
        gallerist.setCreatedAt(new Date());
        BeanUtils.copyProperties(dtoGaleristIU, gallerist);
        gallerist.setAddress(addressOpt.get());
        return gallerist;
    }

    @Override
    public DtoGalerist saveGallerist(DtoGaleristIU dtoGaleristIU) {
        DtoGalerist dtoGalerist = new DtoGalerist();
        DtoAddress dtoAddress = new DtoAddress();
        Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGaleristIU));
        BeanUtils.copyProperties(savedGallerist, dtoGalerist);
        BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);
        dtoGalerist.setAddress(dtoAddress);
        return dtoGalerist;
    }
}
