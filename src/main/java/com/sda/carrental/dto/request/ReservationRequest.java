package com.sda.carrental.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @Size(min = 13, max = 16)
    private String creditCardNumber;

    @NotNull
    private Long pickUpLocationId;

    @NotNull
    private Long returnLocationId;

    @NotNull
    private Long carId;

    @NotNull
    private Long userId;
}
