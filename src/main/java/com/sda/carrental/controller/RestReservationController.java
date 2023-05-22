package com.sda.carrental.controller;

import com.sda.carrental.dto.request.ReservationRequest;
import com.sda.carrental.dto.response.ReservationResponse;
import com.sda.carrental.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class RestReservationController {
    private final ReservationService reservationService;

    @GetMapping("/find-all")
    private ResponseEntity<List<ReservationResponse>> findAllReservations() {
        return ResponseEntity.ok(reservationService.findAllReservations());
    }

    @GetMapping("/find-by-id/{id}")
    private ResponseEntity<ReservationResponse> findReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.findReservationById(id));
    }

    @PostMapping("/save")
    private ResponseEntity<ReservationResponse> saveReservation(@RequestBody @Valid ReservationRequest reservation) {
        return ResponseEntity.ok(reservationService.saveReservation(reservation));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<ReservationResponse> updateReservation(@PathVariable Long id, @RequestBody ReservationRequest reservation) {
        return ResponseEntity.ok(reservationService.updateReservation(id, reservation));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
    }
}