package com.sda.carrental.controller;



import com.sda.carrental.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class RestReservationController {
    private final ReservationService reservationService;
    @GetMapping("/{id}")
    private ResponseEntity<?> findCarById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.findReservationById(id));
    }

}
