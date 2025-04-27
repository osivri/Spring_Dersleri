package com.example.services.impl;

import com.example.dto.DtoAddress;
import com.example.dto.DtoAddressIU;
import com.example.exception.BaseException;
import com.example.exception.ErrorMessage;
import com.example.exception.MessageType;
import com.example.models.Address;
import com.example.repository.AddressRepository;
import com.example.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    private Address createAddress(DtoAddressIU addressIU){
        Address address = new Address();
        address.setCreatedAt(new Date());
        address.setCity(addressIU.getCity());
        address.setDistrict(addressIU.getDistrict());
        address.setStreet(addressIU.getStreet());
        address.setNeighborhood(addressIU.getNeighborhood());
        BeanUtils.copyProperties(addressIU,address);
        return address;
    }


    @Override
    public DtoAddress saveAddress(DtoAddressIU address) {
        DtoAddress dtoAddress = new DtoAddress();
        Address savedAddress = addressRepository.save(createAddress(address));
        BeanUtils.copyProperties(savedAddress,dtoAddress);
        return dtoAddress;
    }
}
