package com.sda.carrental.service;

import com.sda.carrental.dto.request.LocationRequest;
import com.sda.carrental.dto.response.LocationResponse;
import com.sda.carrental.mapper.LocationMapper;
import com.sda.carrental.model.LocationEntity;
import com.sda.carrental.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationMapper locationMapper;

    private final LocationRepository locationRepository;

    public LocationResponse saveLocation(LocationRequest locationRequest) {
        return locationMapper.responseFrom(locationRepository.save(locationMapper.toNewEntity(locationRequest)));
    }

    public List<LocationResponse> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(locationMapper::responseFrom)
                .toList();
    }

    public LocationResponse getLocationById(Long id) {
        return locationMapper.responseFrom(locationRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }

    public LocationResponse updateLocation(Long id, LocationRequest locationRequest) {
        LocationEntity modifiedLocation = locationRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        modifiedLocation.setCountry(locationRequest.getCountry());
        modifiedLocation.setCity(locationRequest.getCity());
        modifiedLocation.setStreet(locationRequest.getStreet());
        modifiedLocation.setBuildingNumber(locationRequest.getBuildingNumber());
        return locationMapper.responseFrom(locationRepository.save(modifiedLocation));
    }

    public void deleteLocation(Long id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
        }
    }
}
