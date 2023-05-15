package com.sda.carrental.controller;

import com.sda.carrental.dto.CarDto;
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

    @GetMapping
    private ResponseEntity<List<CarDto>> findAllCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    @GetMapping("/{id}")
    private ResponseEntity<CarDto> findCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }

    @PostMapping
    private ResponseEntity<CarDto> saveCar(@RequestBody @Valid CarDto car) {
        return ResponseEntity.ok(carService.saveCar(car));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
    }

}
