package com.sda.carrental.dto.response;

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
}
