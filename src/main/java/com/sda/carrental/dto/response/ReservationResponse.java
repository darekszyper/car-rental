package com.sda.carrental.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.carrental.model.LocationEntity;
import com.sda.carrental.model.ReservationEntity;
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
    private LocationEntity pickUpLocation;
    private LocationEntity returnLocation;
    //private CarEntity car;
    //private UserEntity user;
private long car;
private long user;

    //@JsonIgnore
    //public static ReservationResponse from(ReservationEntity source, CarEntity carSource, UserEntity userSource) {
    //    return ReservationResponse.builder()
    //            .reservationId(source.getReservationId())
    //            .startDate(source.getStartDate())
    //            .endDate(source.getEndDate())
    //            .reservationStatus(source.getReservationStatus())
    //            .creditCardNumber(source.getCreditCardNumber())
    //            .reservationNumber(source.getReservationNumber())
    //            .pickUpLocation(source.getPickUpLocation())
    //            .returnLocation(source.getReturnLocation())
    //            .carID(carSource.getCarId())
    //            .userID(userSource.getUserId())
    //            .build();
    //}
    @JsonIgnore
    public static ReservationResponse from(ReservationEntity source) {
        return ReservationResponse.builder()
                .reservationId(source.getReservationId())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .reservationStatus(source.getReservationStatus())
                .creditCardNumber(source.getCreditCardNumber())
                .reservationNumber(source.getReservationNumber())
                .pickUpLocation(source.getPickUpLocation())
                .returnLocation(source.getReturnLocation())
                .car(source.getCar().getCarId())
                .user(source.getUser().getUserId())
                .build();
    }

}
