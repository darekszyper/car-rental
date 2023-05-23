package com.sda.carrental.dto.response;

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
}
