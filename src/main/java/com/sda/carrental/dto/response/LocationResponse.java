package com.sda.carrental.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.carrental.model.LocationEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponse {

    private Long locationId;

    private String country;

    private String city;

    private String street;

    private String buildingNumber;

    @JsonIgnore
    public static LocationResponse from(LocationEntity source) {
        return LocationResponse.builder()
                .locationId(source.getLocationId())
                .country(source.getCountry())
                .city(source.getCity())
                .street(source.getStreet())
                .buildingNumber(source.getBuildingNumber())
                .build();
    }
}
