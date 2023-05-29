package com.sda.carrental.service;


import com.sda.carrental.dto.request.ReservationRequest;
import com.sda.carrental.dto.response.ReservationResponse;
import com.sda.carrental.mapper.ReservationMapper;
import com.sda.carrental.model.ReservationEntity;
import com.sda.carrental.model.enums.ReservationStatus;
import com.sda.carrental.repository.CarRepository;
import com.sda.carrental.repository.LocationRepository;
import com.sda.carrental.repository.ReservationRepository;
import com.sda.carrental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationMapper reservationMapper;

    private final ReservationRepository reservationRepository;

    private final LocationRepository locationRepository;

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    public ReservationResponse findReservationById(Long id) {
        return reservationMapper.responseFrom(reservationRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public ReservationResponse saveReservation(ReservationRequest reservation) {
        ReservationEntity reservationEntity = reservationMapper.toNewEntity(reservation);
        reservationEntity.setReservationStatus(ReservationStatus.CONFIRMED);
        reservationEntity.setReservationNumber("Create reservation number generator");
        return reservationMapper.responseFrom(reservationRepository.save(reservationEntity));
    }

    public void deleteReservationById(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
        }
    }

    public List<ReservationResponse> findAllReservations() {
        return reservationRepository.findAll().stream().map(reservationMapper::responseFrom).collect(Collectors.toList());
    }

    public ReservationResponse updateReservation(Long id, ReservationRequest reservation) {
        ReservationEntity updatedReservation = reservationRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        updatedReservation.setStartDate(reservation.getStartDate());
        updatedReservation.setEndDate(reservation.getEndDate());
        updatedReservation.setCreditCardNumber(reservation.getCreditCardNumber());
        updatedReservation.setPickUpLocation(locationRepository.findById(reservation
                .getPickUpLocationId()).orElse(null));
        updatedReservation.setReturnLocation(locationRepository.findById(reservation
                .getReturnLocationId()).orElse(null));
        updatedReservation.setCar(carRepository.findById(reservation.getCarId()).orElse(null));
        updatedReservation.setUser(userRepository.findById(reservation.getUserId()).orElse(null));

        ReservationEntity savedReservation = reservationRepository.save(updatedReservation);

        return reservationMapper.responseFrom(savedReservation);
    }

    public ReservationResponse cancelReservationById(Long id) {
        ReservationEntity cancelledReservation = reservationRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        cancelledReservation.setReservationStatus(ReservationStatus.CANCELLED);
        return reservationMapper.responseFrom(reservationRepository.save(cancelledReservation));
    }
}
