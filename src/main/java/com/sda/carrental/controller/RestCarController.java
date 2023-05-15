package com.sda.carrental.controller;

import com.sda.carrental.dto.CarDto;
import com.sda.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class RestCarController {

    private final CarService carService;

    @GetMapping("/{id}")
    private ResponseEntity<CarDto> findCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }


}
