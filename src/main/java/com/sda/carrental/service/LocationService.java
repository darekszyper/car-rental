package com.sda.carrental.service;

import com.sda.carrental.dto.request.LocationRequest;
import com.sda.carrental.dto.response.LocationResponse;
import com.sda.carrental.model.LocationEntity;
import com.sda.carrental.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationResponse saveLocation(LocationRequest locationRequest) {
        return LocationResponse.from(locationRepository.save(LocationEntity.toNewEntity(locationRequest)));
    }
}
