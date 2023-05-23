package com.sda.carrental.mapper;

import com.sda.carrental.dto.request.ReservationRequest;
import com.sda.carrental.dto.response.ReservationResponse;
import com.sda.carrental.model.ReservationEntity;
import com.sda.carrental.repository.CarRepository;
import com.sda.carrental.repository.LocationRepository;
import com.sda.carrental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReservationMapper {

    private final LocationRepository locationRepository;

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    private final LocationMapper locationMapper;

    private final CarMapper carMapper;

    private final UserMapper userMapper;


    public ReservationEntity toNewEntity(ReservationRequest source) {
        return ReservationEntity.builder()
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .reservationStatus(source.getReservationStatus())
                .creditCardNumber(source.getCreditCardNumber())
                .reservationNumber(source.getReservationNumber())
                .pickUpLocation(locationRepository
                        .findById(source.getPickUpLocationId()).orElse(null))
                .returnLocation(locationRepository
                        .findById(source.getReturnLocationId()).orElse(null))
                .car(carRepository
                        .findById(source.getCarId()).orElse(null))
                .user(userRepository
                        .findById(source.getUserId()).orElse(null))
                .build();
    }

    public ReservationResponse responseFrom(ReservationEntity source) {
        return ReservationResponse.builder()
                .reservationId(source.getReservationId())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .reservationStatus(source.getReservationStatus())
                .creditCardNumber(source.getCreditCardNumber())
                .reservationNumber(source.getReservationNumber())
                .pickUpLocation(locationMapper.responseFrom(source.getPickUpLocation()))
                .returnLocation(locationMapper.responseFrom(source.getReturnLocation()))
                .car(carMapper.responseFrom(source.getCar()))
                .user(userMapper.responseFrom(source.getUser()))
                .build();
    }
}
