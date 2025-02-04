package com.aplikacja.przyklad1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "content")
public class ImageContent {
    @Id
    private String id;
    private String text;
    private String imageUrl;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
