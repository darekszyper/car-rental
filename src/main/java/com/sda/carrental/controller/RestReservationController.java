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

    @GetMapping("/admin/find-all")
    public ResponseEntity<List<ReservationResponse>> findAllReservations() {
        return ResponseEntity.ok(reservationService.findAllReservations());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<ReservationResponse> findReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.findReservationById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<ReservationResponse> saveReservation(@RequestBody @Valid ReservationRequest reservation) {
        return ResponseEntity.ok(reservationService.saveReservation(reservation));
    }

    @PutMapping("/admin/update/{id}")
    public ResponseEntity<ReservationResponse> updateReservation(@PathVariable Long id, @RequestBody ReservationRequest reservation) {
        return ResponseEntity.ok(reservationService.updateReservation(id, reservation));
    }

    @DeleteMapping("/admin/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
    }

    @PutMapping("/admin/cancel/{id}")
    public ResponseEntity<ReservationResponse> cancelReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.cancelReservationById(id));
    }
}