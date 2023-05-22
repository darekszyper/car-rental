package com.sda.carrental.dto.request;

import com.sda.carrental.model.CarEntity;
import com.sda.carrental.model.LocationEntity;
import com.sda.carrental.model.UserEntity;
import com.sda.carrental.model.enums.ReservationStatus;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @Enumerated
    private ReservationStatus reservationStatus;

    @NotNull
    private String creditCardNumber;

    @NotBlank
    private String reservationNumber;
    @NotNull
    private LocationEntity pickUpLocation;
    @NotNull
    private LocationEntity returnLocation;
    @NotNull
    private CarEntity car;
    @NotNull
    private UserEntity user;
}
