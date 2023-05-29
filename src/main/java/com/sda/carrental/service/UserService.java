package com.sda.carrental.service;

import com.sda.carrental.dto.request.UserRequest;
import com.sda.carrental.dto.response.UserResponse;
import com.sda.carrental.mapper.UserMapper;
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

    private final UserMapper userMapper;

    public UserResponse findUserById(Long id) {
        return userMapper.responseFrom(userRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public List<UserResponse> findAllUsers() {
        return userRepository.findAll().stream().map(userMapper::responseFrom).collect(Collectors.toList());
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

        UserEntity savedUser = userRepository.save(updatedUser);

        return userMapper.responseFrom(savedUser);
    }
}
