package com.sda.carrental.service;

import com.sda.carrental.dto.request.LocationRequest;
import com.sda.carrental.dto.response.LocationResponse;
import com.sda.carrental.model.LocationEntity;
import com.sda.carrental.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationResponse saveLocation(LocationRequest locationRequest) {
        return LocationResponse.from(locationRepository.save(LocationEntity.toNewEntity(locationRequest)));
    }

    public List<LocationResponse> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(LocationResponse::from)
                .toList();
    }

    public LocationResponse getLocationById(Long id) {
        return LocationResponse.from(locationRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }

    public LocationResponse updateLocation(Long id, LocationRequest locationRequest) {
        LocationEntity modifiedLocation = locationRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        modifiedLocation.setCountry(locationRequest.getCountry());
        modifiedLocation.setCity(locationRequest.getCity());
        modifiedLocation.setStreet(locationRequest.getStreet());
        modifiedLocation.setBuildingNumber(locationRequest.getBuildingNumber());
        return LocationResponse.from(locationRepository.save(modifiedLocation));
    }

    public void deleteLocation(Long id) {
        locationRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        locationRepository.deleteById(id);
    }
}
