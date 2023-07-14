package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.data.repository.PasswordRepository;
import com.example.megaPassworkSaver.service.PasswordServiceZ;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@AllArgsConstructor
public class PasswordServiceZImpl implements PasswordServiceZ {
    private final PasswordRepository passwordRepository;

    private String decryptPassword(String encodedPassword) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword.getBytes(StandardCharsets.UTF_8));
        return new String(decodedBytes);
    }



    private String encryptPassword(String password) {
        byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
       return new String(encodedBytes);
    }


    @Override
    public void createPassword(Password password2) {
        String encryptedPassword = encryptPassword(password2.getPassword());
        password2.setCreatedAt(LocalDateTime.now());
        password2.setPassword(encryptedPassword);
       passwordRepository.save(password2);
    }
}
