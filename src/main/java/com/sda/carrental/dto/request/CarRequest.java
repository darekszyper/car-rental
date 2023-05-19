package com.sda.carrental.dto.request;

import com.sda.carrental.model.enums.CarType;
import com.sda.carrental.model.enums.Transmission;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {

    @NotBlank
    private String make;

    @NotBlank
    private String model;

    @Enumerated
    private Transmission transmission;

    @Enumerated
    private CarType carType;

    @Pattern(regexp = "\\d{4}", message = "Production year must have 4 digits")
    private String productionYear;

    @NotNull
    private BigDecimal pricePerDay;
}
