package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.exception.EmailSenderException;
import com.example.megaPassworkSaver.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceIMLP implements EmailService {


@Value("${spring.mail.host}")
private String host;
@Value("${spring.mail.username}")
private String fromEmail;

private final JavaMailSenderImpl mailSenderImpl;
    @Override
    public void sendSimpleMailMessage(String name, String to, String token) {
    try {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("new user account verification");
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setText("this is working thank God");
        mailSenderImpl.send(message);
    }catch (Exception exception) {
        System.out.println(exception.getMessage());
        throw new EmailSenderException("Failed to send  mail message");
    }
    }

    @Override
    public void sendMimeMessageWithAttachment(String name, String to, String token) {

    }

    @Override
    public void sendMimeMessageWithEmbeddedImage(String name, String to, String token) {

    }

    @Override
    public void sendMimeMesWithEmbeddedFiles(String name, String to, String token) {

    }

    @Override
    public void sendHTML(String name, String to, String token) {

    }

    @Override
    public void sendHtmlEmailWithEmbeddedFiles(String name, String to, String token) {

    }
}
