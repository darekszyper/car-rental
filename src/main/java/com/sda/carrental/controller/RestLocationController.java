package com.sda.carrental.controller;

import com.sda.carrental.dto.request.LocationRequest;
import com.sda.carrental.dto.response.LocationResponse;
import com.sda.carrental.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class RestLocationController {

    private final LocationService locationService;

    @GetMapping("/find-all")
    private ResponseEntity<List<LocationResponse>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping("/find-by-id/{id}")
    private ResponseEntity<LocationResponse> getLocationById(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    private ResponseEntity<LocationResponse> saveLocation(@RequestBody @Valid LocationRequest locationRequest) {
        return ResponseEntity.ok(locationService.saveLocation(locationRequest));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<LocationResponse> updateLocation(@PathVariable Long id,
                                                            @RequestBody @Valid LocationRequest locationRequest) {
        return ResponseEntity.ok(locationService.updateLocation(id, locationRequest));
    }

    @DeleteMapping("/delete/{id}")
    private void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}
