package com.sda.carrental.controller;

import com.sda.carrental.dto.request.CarRequest;
import com.sda.carrental.dto.response.CarResponse;
import com.sda.carrental.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class RestCarController {

    private final CarService carService;

    @GetMapping("/find-all")
    private ResponseEntity<List<CarResponse>> findAllCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    @GetMapping("/find-by-id/{id}")
    private ResponseEntity<CarResponse> findCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }

    @PostMapping("/save")
    private ResponseEntity<CarResponse> saveCar(@RequestBody @Valid CarRequest car) {
        return ResponseEntity.ok(carService.saveCar(car));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<CarResponse> updateCar(@PathVariable Long id, @RequestBody CarRequest car) {
        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
    }
}
