package com.sda.carrental.dto.response;

import com.sda.carrental.model.enums.ReservationStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {


    private Long reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private ReservationStatus reservationStatus;
    private String creditCardNumber;
    private String reservationNumber;
    private LocationResponse pickUpLocation;
    private LocationResponse returnLocation;
    private CarResponse car;
    private UserResponse user;
}
