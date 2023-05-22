package com.sda.carrental.service;


import com.sda.carrental.dto.request.ReservationRequest;

import com.sda.carrental.dto.response.ReservationResponse;

import com.sda.carrental.model.ReservationEntity;

import com.sda.carrental.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationResponse findReservationById(Long id) {
        return ReservationResponse.from(reservationRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public ReservationResponse saveReservation(ReservationRequest reservation) {
        return ReservationResponse.from(reservationRepository.save(ReservationEntity.toNewEntity(reservation)));
    }

    public void deleteReservationById(Long id) {
        ReservationEntity reservation = reservationRepository.findById(id).orElseThrow(RuntimeException::new);
        reservationRepository.delete(reservation);
    }

    public List<ReservationResponse> findAllReservations() {
        return reservationRepository.findAll().stream().map(ReservationResponse::from).collect(Collectors.toList());
    }

    public ReservationResponse updateReservation(Long id, ReservationRequest reservation) {
        ReservationEntity updatedReservation = reservationRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        updatedReservation.setStartDate(reservation.getStartDate());
        updatedReservation.setEndDate(reservation.getEndDate());
        updatedReservation.setReservationStatus(reservation.getReservationStatus());
        updatedReservation.setCreditCardNumber(reservation.getCreditCardNumber());
        updatedReservation.setReservationNumber(reservation.getReservationNumber());
        updatedReservation.setPickUpLocation(reservation.getPickUpLocation());
        updatedReservation.setReturnLocation(reservation.getReturnLocation());
        updatedReservation.setCar(reservation.getCar());
        updatedReservation.setUser(reservation.getUser());

        ReservationEntity savedReservation = reservationRepository.save(updatedReservation);

        return ReservationResponse.from(savedReservation);
    }
}
