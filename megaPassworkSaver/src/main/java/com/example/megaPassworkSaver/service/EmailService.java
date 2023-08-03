package com.example.megaPassworkSaver.service;

public interface EmailService {
    void sendSimpleMailMessage(String name, String to , String token);
    void sendMimeMessageWithAttachment(String name, String to , String token);
    void sendMimeMessageWithEmbeddedImage(String name, String to , String token);
    void sendMimeMesWithEmbeddedFiles(String name, String to , String token);
    void sendHTML(String name, String to , String token);
    void sendHtmlEmailWithEmbeddedFiles(String name, String to , String token);
}
