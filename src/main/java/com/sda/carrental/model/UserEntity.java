package com.sda.carrental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.carrental.dto.request.UserRequest;
import com.sda.carrental.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "id_card_number")
    private String idCardNumber;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<ReservationEntity> reservations = new HashSet<>(); //sprawdzić czy bez inicjalizacji też działa

    @JsonIgnore
    public static UserEntity toNewEntity(UserRequest source) {
        return UserEntity.builder()
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .phoneNumber(source.getPhoneNumber())
                .idCardNumber(source.getIdCardNumber())
                .password(source.getPassword())
                .role(source.getRole())
                .reservations(source.getReservations())
                .build();
    }

}
