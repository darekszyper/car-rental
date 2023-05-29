package com.sda.carrental.mapper;

import com.sda.carrental.dto.request.CarRequest;
import com.sda.carrental.dto.response.CarResponse;
import com.sda.carrental.model.CarEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CarMapper {

    public CarEntity toNewEntity(CarRequest source) {
        return CarEntity.builder()
                .make(source.getMake())
                .model(source.getModel())
                .transmission(source.getTransmission())
                .carType(source.getCarType())
                .productionYear(source.getProductionYear())
                .pricePerDay(source.getPricePerDay())
                .build();
    }

    public CarResponse responseFrom(CarEntity source) {
        return CarResponse.builder()
                .carId(source.getCarId())
                .make(source.getMake())
                .model(source.getModel())
                .transmission(source.getTransmission())
                .carType(source.getCarType())
                .productionYear(source.getProductionYear())
                .pricePerDay(source.getPricePerDay())
                .build();
    }
}
