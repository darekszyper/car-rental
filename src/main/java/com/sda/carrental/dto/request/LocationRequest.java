package com.sda.carrental.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest {

    @NotBlank(message = "country is required")
    private String country;

    @NotBlank(message = "city is required")
    private String city;

    @NotBlank(message = "street is required")
    private String street;

    @Size(min = 1, max = 5, message = "building number cant be longer than 5 signs")
    private String buildingNumber;
}
