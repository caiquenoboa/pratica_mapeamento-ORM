package com.example.demo.dto;

import com.example.demo.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserUpdateRequest {
    private Long id;
    private String name;
    private UserEntity.UserType type;
}
