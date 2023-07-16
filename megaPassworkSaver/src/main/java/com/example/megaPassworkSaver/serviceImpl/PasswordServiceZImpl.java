package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.data.model.Token;
import com.example.megaPassworkSaver.data.repository.PasswordRepository;
import com.example.megaPassworkSaver.data.repository.TokenRepository;
import com.example.megaPassworkSaver.exception.AppUserException;
import com.example.megaPassworkSaver.exception.PasswordException;
import com.example.megaPassworkSaver.service.PasswordServiceZ;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@RequiredArgsConstructor
@Transactional

public class PasswordServiceZImpl implements PasswordServiceZ {

    private final PasswordRepository passwordRepository;

   private final TokenRepository tokenRepository;

    public String decryptPassword(String encodedPassword) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword.getBytes(StandardCharsets.UTF_8));
        return new String(decodedBytes);
    }



    private String encryptPassword(String password) {
        byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
       return new String(encodedBytes);
    }
public Password findPassword(String passwordLabel) {
if (passwordRepository.findByPasswordLabel(passwordLabel) == null)
throw new PasswordException("Password does not exist");
return passwordRepository.findByPasswordLabel(passwordLabel);
    }

    @Override
    public Password createPassword(Password password2) {
        String encryptedPassword = encryptPassword(password2.getPassword());
        password2.setCreatedAt(LocalDateTime.now());
        password2.setPassword(encryptedPassword);
       // throw (password2.getAppUser() == null) ? new AppUserException("User must be provided");
        if (password2.getAppUser() == null) throw new  AppUserException("User must be provided");
        return   passwordRepository.save(password2) ;


    }

    @Override
    public long countAllPassword() {
        return passwordRepository.count();
    }

    @Override
    public void deleteAllPassword() {
        passwordRepository.deleteAll();
    }

    @Override
    public void deletePasswordByLabel(String passwordLabel) {
        passwordRepository.deleteByPasswordLabel(passwordLabel);
    }

@Transactional
    public Token tokenGenerator(String passwordLabel) {
        StringBuilder buildedString = new StringBuilder(passwordLabel);
        Password foundPassword = findPassword(passwordLabel);
String word =   (String) buildedString.subSequence(3, passwordLabel.length()-2);
    System.out.println("(**)-->  " + word);
    String hashLabel = decryptPassword("boneshaker");
   Token token = Token.builder()
            .generatedAt(LocalDateTime.now())
            .token(hashLabel)
           .expiredAt(LocalDateTime.now())
            .build();
      foundPassword.setToken(token.getToken());
      token.setPassword(foundPassword);
      passwordRepository.save(foundPassword);
//      return token;
      return tokenRepository.save(token);
  }


}
