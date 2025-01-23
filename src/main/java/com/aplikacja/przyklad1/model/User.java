package com.aplikacja.przyklad1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



    @Document
    public class User {
        @Id
        private String id;
        private String name;
        private String email;
    }

