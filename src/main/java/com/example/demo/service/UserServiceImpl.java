package com.example.demo.service;

import com.example.demo.dto.UserCompleteResponse;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity(null, userRequest.getName(), userRequest.getType(), null);
        userEntity = userRepository.save(userEntity);
        return new UserResponse(userEntity);
    }

    @Override
    public UserEntity findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse updateById(UserUpdateRequest userUpdateRequest) {
        UserEntity userEntity = findById(userUpdateRequest.getId());
        userEntity.setName(userUpdateRequest.getName());
        userEntity.setType(userUpdateRequest.getType());

        return new UserResponse(userRepository.save(userEntity));
    }

    public UserCompleteResponse findCompleteUserById(Long id){
        UserEntity userEntity = findById(id);

        return new UserCompleteResponse(userEntity);
    }


}
