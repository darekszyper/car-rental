package com.sda.carrental.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.carrental.model.CarEntity;
import com.sda.carrental.model.LocationEntity;
import com.sda.carrental.model.ReservationEntity;
import com.sda.carrental.model.enums.CarType;
import com.sda.carrental.model.enums.ReservationStatus;
import com.sda.carrental.model.enums.Transmission;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private Long reservationId;
    private LocalDate startDate;

    private LocalDate endDate;
    private ReservationStatus reservationStatus;
    private String creditCardNumber;
    private String reservationNumber;
    private LocationEntity pickUpLocation;
    private LocationEntity returnLocation;

    @JsonIgnore
    public static ReservationDto from(ReservationEntity source) {
        return ReservationDto.builder()
                .reservationId(source.getReservationId())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .reservationStatus(source.getReservationStatus())
                .creditCardNumber(source.getCreditCardNumber())
                .reservationNumber(source.getReservationNumber())
                .pickUpLocation(source.getPickUpLocation())
                .returnLocation(source.getReturnLocation())
                .build();
    }
}
