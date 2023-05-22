package com.sda.carrental.service;

import com.sda.carrental.dto.request.UserRequest;
import com.sda.carrental.dto.response.UserResponse;
import com.sda.carrental.model.UserEntity;
import com.sda.carrental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse findUserById(Long id) {
        return UserResponse.from(userRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public UserResponse saveUser(UserRequest user) {
        return UserResponse.from(userRepository.save(UserEntity.toNewEntity(user)));
    }

    public void deleteUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        userRepository.delete(user);
    }

    public List<UserResponse> findAllUsers() {
        return userRepository.findAll().stream().map(UserResponse::from).collect(Collectors.toList());
    }

    public UserResponse updateUser(Long id, UserRequest user) {
        UserEntity updatedUser = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPhoneNumber(user.getPhoneNumber());
        updatedUser.setIdCardNumber(user.getIdCardNumber());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setRole(user.getRole());
        updatedUser.setReservations(user.getReservations());


        UserEntity savedUser = userRepository.save(updatedUser);

        return UserResponse.from(savedUser);
    }
}
