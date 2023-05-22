package com.sda.carrental.dto.request;

import com.sda.carrental.model.ReservationEntity;
import com.sda.carrental.model.enums.Role;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String idCardNumber;

    @NotBlank
    private String password;
    @Enumerated
    private Role role;
    @NotBlank
    private Set<ReservationEntity> reservations;
}
