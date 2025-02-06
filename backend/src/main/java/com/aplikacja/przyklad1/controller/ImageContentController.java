package com.aplikacja.przyklad1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.aplikacja.przyklad1.model.ImageContent;
import com.aplikacja.przyklad1.repository.ImageContentRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://20.121.42.213:8081")
@RestController
@RequestMapping("/api/content")
public class ImageContentController {
    @Autowired
    private ImageContentRepository imageContentRepository;

     // Pobieranie wszystkich treści
     @GetMapping
     public List<ImageContent> getAllContent() {
         return imageContentRepository.findAll();
     }
     // Pobieranie pojedynczej treści po ID
     @GetMapping("/{id}")
     public ResponseEntity<ImageContent> getContentById(@PathVariable String id) {
        Optional<ImageContent> imageContent = imageContentRepository.findById(id);
        if (imageContent.isPresent()) {
            return ResponseEntity.ok(imageContent.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
     }
    //  Dodajemy nową treść
     @PostMapping
     public ImageContent createContent(@RequestBody ImageContent content) {
        return imageContentRepository.save(content);
     }

    //  Aktualizacja treści
    @PutMapping("/{id}")
    public ResponseEntity<ImageContent> updateContent(@PathVariable String id, @RequestBody ImageContent contentDetails) {
        Optional<ImageContent> imageData = imageContentRepository.findById(id);

        if (imageData.isPresent()) {
            ImageContent updateContent = imageData.get();
            updateContent.setText(contentDetails.getText());
            updateContent.setImageUrl(contentDetails.getImageUrl());
            imageContentRepository.save(updateContent);
            return ResponseEntity.ok(updateContent);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteContent(@PathVariable String id) {
        try {
            imageContentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}