package com.sda.carrental.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.carrental.model.CarEntity;
import com.sda.carrental.model.enums.CarType;
import com.sda.carrental.model.enums.Transmission;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private Long carId;

    private String make;

    private String model;

    private Transmission transmission;

    private CarType carType;

    @Pattern(regexp = "\\d{4}", message = "Production year must have 4 digits")
    private String productionYear;

    private BigDecimal pricePerDay;

   @JsonIgnore
   public static CarDto from(CarEntity source)  {
       return CarDto.builder()
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
