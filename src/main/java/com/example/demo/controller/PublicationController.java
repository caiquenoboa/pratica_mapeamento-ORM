package com.example.demo.controller;

import com.example.demo.dto.PublicationRequest;
import com.example.demo.dto.PublicationResponse;
import com.example.demo.dto.PublicationUpdateRequest;
import com.example.demo.entity.PublicationEntity;
import com.example.demo.service.PublicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    private final PublicationServiceImpl publicationService;

    public PublicationController(PublicationServiceImpl publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping
    public ResponseEntity<PublicationResponse> addPublication(@RequestBody PublicationRequest publicationRequest) {

        PublicationResponse newPublication = publicationService.addPublication(publicationRequest);

        return new ResponseEntity<>(newPublication, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PublicationResponse> getPublication(@PathVariable Long id){
        PublicationResponse publicationResponse = publicationService.findById(id);
        return ResponseEntity.ok(publicationResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePublication(@PathVariable Long id){
        publicationService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping
    public ResponseEntity<PublicationResponse> updatePublication(@RequestBody PublicationUpdateRequest publicationRequest){

        PublicationResponse publicationResponse = publicationService.updateById(publicationRequest);

        return new ResponseEntity<>(publicationResponse, HttpStatus.ACCEPTED);

    }
}
