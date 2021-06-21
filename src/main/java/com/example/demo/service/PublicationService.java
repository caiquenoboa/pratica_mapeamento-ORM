package com.example.demo.service;


import com.example.demo.dto.PublicationRequest;
import com.example.demo.dto.PublicationResponse;
import com.example.demo.dto.PublicationUpdateRequest;
import com.example.demo.entity.PublicationEntity;

public interface PublicationService {

    public PublicationResponse addPublication(PublicationRequest publicationRequest);

    PublicationResponse findById(Long id);

    public void deleteById(Long id);

    PublicationResponse updateById(PublicationUpdateRequest publicationUpdateRequest);
}
