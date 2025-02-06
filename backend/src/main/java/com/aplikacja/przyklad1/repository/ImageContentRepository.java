package com.aplikacja.przyklad1.repository;

import com.aplikacja.przyklad1.model.ImageContent;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ImageContentRepository extends MongoRepository<ImageContent, String> {

}

