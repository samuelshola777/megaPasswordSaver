package com.example.megaPassworkSaver.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacebookPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String message;
    private URL imageUrl;
    private URL videoUrl;
    private URL link;


}
