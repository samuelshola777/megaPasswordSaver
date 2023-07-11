package com.example.megaPassworkSaver.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class FacebookPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
