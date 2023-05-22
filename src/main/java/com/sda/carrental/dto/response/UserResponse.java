package com.sda.carrental.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.carrental.model.UserEntity;
import com.sda.carrental.model.enums.Role;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String idCardNumber;
    private Role role;


    @JsonIgnore
    public static UserResponse from(UserEntity source) {
        return UserResponse.builder()
                .id(source.getUserId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .phoneNumber(source.getPhoneNumber())
                .idCardNumber(source.getIdCardNumber())
                .role(source.getRole())
                .build();
    }

}
