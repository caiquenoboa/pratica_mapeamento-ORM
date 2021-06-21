package com.example.demo.service;

import com.example.demo.dto.PublicationRequest;
import com.example.demo.dto.PublicationResponse;
import com.example.demo.dto.PublicationUpdateRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.PublicationEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.PublicationRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicationServiceImpl implements PublicationService{

    private final PublicationRepository publicationRepository;

    private final UserService userService;

    public PublicationServiceImpl(PublicationRepository publicationRepository, UserService userService) {
        this.publicationRepository = publicationRepository;
        this.userService = userService;
    }

    @Override
    public PublicationResponse addPublication(PublicationRequest publicationRequest) {
        UserEntity userEntity = userService.findById(publicationRequest.getId_user());
        PublicationEntity publicationEntity = new PublicationEntity(null, publicationRequest.getText(), userEntity);

        publicationEntity = publicationRepository.save(publicationEntity);

        return new PublicationResponse(publicationEntity);
    }

    @Override
    public PublicationResponse findById(Long id) {
        PublicationEntity publicationEntity = publicationRepository.findById(id).get();
        return new PublicationResponse(publicationEntity);
    }

    public void deleteById(Long id) {
        publicationRepository.deleteById(id);
    }

    @Override
    public PublicationResponse updateById(PublicationUpdateRequest publicationUpdateRequest) {
        PublicationEntity publicationEntity = publicationRepository.findById(publicationUpdateRequest.getId()).get();
        publicationEntity.setText(publicationUpdateRequest.getText());

        return new PublicationResponse(publicationRepository.save(publicationEntity));


    }
}
