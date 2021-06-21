package com.example.demo.dto;

import com.example.demo.entity.PublicationEntity;
import com.example.demo.entity.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

public class UserResponse {
        private Long id;

        private String name;

        private com.example.demo.entity.UserEntity.UserType type;

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.type = userEntity.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity.UserType getType() {
        return type;
    }

    public void setType(UserEntity.UserType type) {
        this.type = type;
    }
}


