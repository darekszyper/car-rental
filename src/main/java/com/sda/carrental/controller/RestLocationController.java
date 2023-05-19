package com.sda.carrental.controller;

import com.sda.carrental.dto.request.LocationRequest;
import com.sda.carrental.dto.response.LocationResponse;
import com.sda.carrental.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class RestLocationController {

    private final LocationService locationService;

    @PostMapping
    private ResponseEntity<LocationResponse> saveLocation(@RequestBody @Valid LocationRequest locationRequest) {
        return ResponseEntity.ok(locationService.saveLocation(locationRequest));
    }
}
