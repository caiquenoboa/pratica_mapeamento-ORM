package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

public interface UserService {

    public UserResponse addUser(UserRequest userRequest);

    public UserEntity findById(long id);

    void deleteById(Long id);

    UserResponse updateById(UserUpdateRequest userUpdateRequest);
}
