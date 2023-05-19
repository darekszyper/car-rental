package com.sda.carrental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.carrental.dto.request.LocationRequest;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "locations")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "building_number")
    private String buildingNumber;

    @JsonIgnore
    public static LocationEntity toNewEntity(LocationRequest source) {
        return LocationEntity.builder()
                .country(source.getCountry())
                .city(source.getCity())
                .street(source.getStreet())
                .buildingNumber(source.getBuildingNumber())
                .build();
    }
}
