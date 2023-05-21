package com.sda.carrental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.sda.carrental.dto.ReservationDto;
import com.sda.carrental.model.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")

public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private Long reservationId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReservationStatus reservationStatus;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    @Column(name = "reservation_number")
    private String reservationNumber;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id", referencedColumnName = "location_id")
    private LocationEntity pickUpLocation;

    @ManyToOne
    @JoinColumn(name = "return_location_id", referencedColumnName = "location_id")
    private LocationEntity returnLocation;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @JsonIgnore
    public static ReservationDto toNewEntity(ReservationDto source) {
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
