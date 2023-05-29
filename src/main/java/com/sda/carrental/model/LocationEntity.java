package com.sda.carrental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
    @OneToMany(mappedBy = "pickUpLocation")
    private Set<ReservationEntity> reservationsPickUp;

    @JsonIgnore
    @OneToMany(mappedBy = "returnLocation")
    private Set<ReservationEntity> reservationsReturns;
}
