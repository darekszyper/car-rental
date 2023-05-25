package com.sda.carrental.controller;

import com.sda.carrental.dto.request.CarRequest;
import com.sda.carrental.dto.response.CarResponse;
import com.sda.carrental.service.CarService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
@Validated
public class RestCarController {

    private final CarService carService;

    @GetMapping("/find-all")
    public ResponseEntity<List<CarResponse>> findAllCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<CarResponse> findCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }

    @PostMapping("/admin/save")
    public ResponseEntity<CarResponse> saveCar(@RequestBody @Valid CarRequest car) {
        return ResponseEntity.ok(carService.saveCar(car));
    }

    @PutMapping("/admin/update/{id}")
    public ResponseEntity<CarResponse> updateCar(@PathVariable Long id, @RequestBody CarRequest car) {
        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    @DeleteMapping("/admin/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
    }

    @GetMapping("/find-by-date")
    public ResponseEntity<List<CarResponse>> findAvailableCarsByDateWithPrice(
            @RequestParam @NotNull @Future LocalDate startDate,
            @RequestParam @NotNull @Future LocalDate endDate) {
        return ResponseEntity.ok(carService.findAvailableCarsByDateWithPrice(startDate, endDate));
    }
}
