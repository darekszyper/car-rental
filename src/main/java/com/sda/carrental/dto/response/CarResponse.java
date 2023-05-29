package com.sda.carrental.dto.response;

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
}
