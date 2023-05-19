package com.sda.carrental.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.carrental.model.CarEntity;
import com.sda.carrental.model.enums.CarType;
import com.sda.carrental.model.enums.Transmission;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {

    private Long carId;

    private String make;

    private String model;

    private Transmission transmission;

    private CarType carType;

    private String productionYear;

    private BigDecimal pricePerDay;

    @JsonIgnore
    public static CarResponse from(CarEntity source) {
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