package com.sda.carrental.mapper;

import com.sda.carrental.dto.response.UserResponse;
import com.sda.carrental.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    public UserResponse responseFrom(UserEntity source) {
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
