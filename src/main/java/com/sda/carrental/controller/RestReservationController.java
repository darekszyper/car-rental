package com.sda.carrental.controller;



import com.sda.carrental.dto.CarDto;
import com.sda.carrental.dto.ReservationDto;
import com.sda.carrental.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class RestReservationController {
    private final ReservationService reservationService;
    @GetMapping("/{id}")
    private ResponseEntity<?> findReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.findReservationById(id));
    }
    @PostMapping
    private ResponseEntity<ReservationDto> saveReservation (@RequestBody @Valid ReservationDto reservation) {
        return ResponseEntity.ok(reservationService.saveReservation(reservation));
    }

    @PutMapping("/{id}")
    private ResponseEntity<ReservationDto> updateReservation(@PathVariable Long id, @RequestBody ReservationDto reservation) {
        return ResponseEntity.ok(reservationService.updateReservation(id, reservation));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
    }

}
