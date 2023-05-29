package com.sda.carrental.mapper;

import com.sda.carrental.dto.request.LocationRequest;
import com.sda.carrental.dto.response.LocationResponse;
import com.sda.carrental.model.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LocationMapper {

    public LocationEntity toNewEntity(LocationRequest source) {
        return LocationEntity.builder()
                .country(source.getCountry())
                .city(source.getCity())
                .street(source.getStreet())
                .buildingNumber(source.getBuildingNumber())
                .build();
    }

    public LocationResponse responseFrom(LocationEntity source) {
        return LocationResponse.builder()
                .locationId(source.getLocationId())
                .country(source.getCountry())
                .city(source.getCity())
                .street(source.getStreet())
                .buildingNumber(source.getBuildingNumber())
                .build();
    }
}
