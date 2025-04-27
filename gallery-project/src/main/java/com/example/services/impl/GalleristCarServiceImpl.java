package com.example.services.impl;

import com.example.dto.*;
import com.example.exception.BaseException;
import com.example.exception.ErrorMessage;
import com.example.exception.MessageType;
import com.example.models.Car;
import com.example.models.Gallerist;
import com.example.models.GalleristCar;
import com.example.repository.CarRepository;
import com.example.repository.GaleristRepository;
import com.example.repository.GalleristCarRepository;
import com.example.services.IGalleristCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristCarServiceImpl implements IGalleristCarService {

    @Autowired
    private GalleristCarRepository galleristCarRepository;

    @Autowired
    private GaleristRepository galeristRepository;

    @Autowired
    private CarRepository carRepository;

    public GalleristCar createGalleristCar(DtoGalleristCarIU galleristCarIU) {

        Optional<Gallerist> optGallerist = galeristRepository.findById(galleristCarIU.getGalleristId());

        if(optGallerist.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, galleristCarIU.getGalleristId().toString()));
        }
        Optional<Car> optCar = carRepository.findById(galleristCarIU.getCarId());

        if(optCar.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, galleristCarIU.getCarId().toString()));
        }

        GalleristCar galleristCar = new GalleristCar();
        galleristCar.setCreatedAt(new Date());
        galleristCar.setGallerist(optGallerist.get());
        galleristCar.setCar(optCar.get());
        return galleristCar;
    }

    @Override
    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU galleristCar) {
        DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
        DtoGalerist dtoGallerist = new DtoGalerist();
        DtoCar dtoCar = new DtoCar();

        DtoAddress dtoAddress = new DtoAddress();

        GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(galleristCar));

        BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);
        dtoGallerist.setAddress(dtoAddress);
        dtoGalleristCar.setGallerist(dtoGallerist);
        dtoGalleristCar.setCar(dtoCar);
        return dtoGalleristCar;
    }
}
