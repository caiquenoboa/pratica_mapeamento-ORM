package com.example.demo.dto;

import com.example.demo.entity.PublicationEntity;

public class PublicationResponse {

    private Long id;

    private String text;

    private UserResponse userResponse;

    public PublicationResponse() {
    }

    public PublicationResponse(PublicationEntity publicationEntity) {
        this.id = publicationEntity.getId();
        this.text = publicationEntity.getText();
        this.userResponse = new UserResponse(publicationEntity.getUserEntity());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
