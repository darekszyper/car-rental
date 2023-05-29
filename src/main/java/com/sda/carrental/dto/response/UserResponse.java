package com.sda.carrental.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.carrental.model.ReservationEntity;
import com.sda.carrental.model.UserEntity;
import com.sda.carrental.model.enums.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String idCardNumber;
    private Role role;
    private Set<ReservationEntity> reservations;

    @JsonIgnore
    public static UserResponse from(UserEntity source) {
        return UserResponse.builder()
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .phoneNumber(source.getPhoneNumber())
                .idCardNumber(source.getIdCardNumber())
                .role(source.getRole())
                .reservations(source.getReservations())

                .build();
    }

}
