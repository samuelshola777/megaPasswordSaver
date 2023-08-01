package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.data.model.Token;
import com.example.megaPassworkSaver.data.repository.PasswordRepository;
import com.example.megaPassworkSaver.data.repository.TokenRepository;
import com.example.megaPassworkSaver.dto.UnlockPassword;
import com.example.megaPassworkSaver.dto.request.PageRequestDto;
import com.example.megaPassworkSaver.exception.AppUserException;
import com.example.megaPassworkSaver.exception.PasswordException;
import com.example.megaPassworkSaver.service.PasswordServiceZ;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
     return  new String(decodedBytes);}


    private String encryptPassword(String password) {
        if (password.contains(" "))throw new PasswordException("Encrypt  password()-->  invalid password input");
        byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
       return new String(encodedBytes);
    }
public Password findPassword(String passwordLabel) {
if (passwordRepository.findByPasswordLabel(passwordLabel) == null)
throw new PasswordException("Password does not exist");
return passwordRepository.findByPasswordLabel(passwordLabel);
    }

    @Override
    public void deleteAllToken() {
        tokenRepository.deleteAll();
    }

    @Override
    public Password createPassword(Password password2) {
        ifPasswordLabelAlreadyExists(password2.getPasswordLabel());
        if (password2.getSavedPassword().contains(" ")) throw new PasswordException("Create Password()-> invalid Password");
        if (password2.getAppUser() == null) throw new  AppUserException("User must be provided");
        password2.setCreatedAt(LocalDateTime.now());
        password2.setSavedPassword(encryptPassword(password2.getSavedPassword()));
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
        Password foundPassword = findPassword(passwordLabel);
         Token token = Token.builder()
            .generatedAt(LocalDateTime.now())
            .token(encryptPassword(passwordLabel.replace(" ","&").substring(0,6)))
           .expiredAt(LocalDateTime.now())
            .build();
      foundPassword.setToken(token.getToken());
      token.setPassword(foundPassword);
     // passwordRepository.save(foundPassword);
//      return token;
     return tokenRepository.save(token);
  }
  private void ifPasswordLabelAlreadyExists(String passwordLabel){
       if ( passwordRepository.findByPasswordLabel(passwordLabel) != null) throw new PasswordException("Password label already exists");
  }


  public Page<UnlockPassword> viewAllPassword(PageRequestDto pageRequestDto){
      Pageable pageAble = new  PageRequestDto().getPageRequest(pageRequestDto);
      Page<Password> listOfPassword = passwordRepository.findAll(pageAble);
    return (Page<UnlockPassword>) listOfPassword.stream().map(this::mapToUnlockPasswordWithWrongToken);
  }
  public Page<UnlockPassword> viewAllPasswordWithWrongToken(PageRequestDto pageRequestDto){
      Pageable pageAble = new  PageRequestDto().getPageRequest(pageRequestDto);
      Page<Password> listOfPassword = passwordRepository.findAll(pageAble);
    return (Page<UnlockPassword>) listOfPassword.stream().map(this::mapToUnlockPassword);
  }

    public UnlockPassword mapToUnlockPassword(Password password){
        return UnlockPassword.builder()
                .appUserEmail(password.getAppUserEmail())
                .token(password.getToken())
                .createdAt(password.getCreatedAt())
                .LastUpdatedAt(password.getLastUpdatedAt())
                .passwordLabel(password.getPasswordLabel())
                .password(decryptPassword(password.getSavedPassword()))
                .build();
    }
    public UnlockPassword mapToUnlockPasswordWithWrongToken(Password password){
        return UnlockPassword.builder()
                .appUserEmail(password.getAppUserEmail())
                .token(password.getToken())
                .createdAt(password.getCreatedAt())
                .LastUpdatedAt(password.getLastUpdatedAt())
                .passwordLabel(password.getPasswordLabel())
                .password(password.getSavedPassword())
                .build();
    }
    private Token findTokenByToken(String token) {
       return tokenRepository.findByToken(token);
    }

}
