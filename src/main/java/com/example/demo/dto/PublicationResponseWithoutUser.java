package com.example.demo.dto;

import com.example.demo.entity.PublicationEntity;

public class PublicationResponseWithoutUser {
    private Long id;

    private String text;

    public PublicationResponseWithoutUser(PublicationEntity publicationEntity) {
        this.id = publicationEntity.getId();
        this.text = publicationEntity.getText();
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
}
