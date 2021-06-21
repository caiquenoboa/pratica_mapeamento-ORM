package com.example.demo.dto;

import com.example.demo.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserCompleteResponse {

    private Long id;

    private String name;

    private com.example.demo.entity.UserEntity.UserType type;


    private List<PublicationResponseWithoutUser> publicationResponseWithoutUsers;

    public UserCompleteResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.type = userEntity.getType();
        this.publicationResponseWithoutUsers = userEntity.getPublicationEntities()
                                                            .stream()
                                                            .map(PublicationResponseWithoutUser::new)
                                                            .collect(Collectors.toList());
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

    public List<PublicationResponseWithoutUser> getPublicationResponseWithoutUsers() {
        return publicationResponseWithoutUsers;
    }

    @JsonProperty(value = "publications")
    public void setPublicationResponseWithoutUsers(List<PublicationResponseWithoutUser> publicationResponseWithoutUsers) {
        this.publicationResponseWithoutUsers = publicationResponseWithoutUsers;
    }
}
