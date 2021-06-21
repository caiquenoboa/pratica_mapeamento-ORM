package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.PublicationEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

   private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
        UserResponse newUser = userService.addUser(userRequest);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCompleteResponse> getUser(@PathVariable Long id){
        UserCompleteResponse userResponse = userService.findCompleteUserById(id);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserUpdateRequest userUpdateRequest){

        UserResponse userResponse = userService.updateById(userUpdateRequest);

        return new ResponseEntity<>(userResponse, HttpStatus.ACCEPTED);

    }
}
