package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.data.model.AppUser;
import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.data.model.Token;
import com.example.megaPassworkSaver.data.repository.AppUserRepositoryZ;
import com.example.megaPassworkSaver.dto.UnlockPassword;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import com.example.megaPassworkSaver.exception.EmailAlreadyExistException;
import com.example.megaPassworkSaver.exception.RegistrationException;
import com.example.megaPassworkSaver.service.AppUserService;
import com.example.megaPassworkSaver.service.PasswordServiceZ;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepositoryZ appUserRepositoryZ;

    private final   PasswordServiceZ passwordServiceZ;


    @Override
    public AppUserResponse registerNewUser(AppUserRequest appUserRequest3) {
        ifEmailAlreadyExist(appUserRequest3.getEmailAddress());
        passwordVerifier(appUserRequest3.getUnlockPassword());
        AppUser mappedAppUser = mapRequestToAppUser(appUserRequest3);
        return mapAppUserToResponse(appUserRepositoryZ.save(mappedAppUser));
    }

    @Override
    public long countUsers() {
        return appUserRepositoryZ.count();
    }

    @Override
    public AppUserResponse userSavePassword(Password password1) {
        AppUser foundUser = findAppUserByEmail(password1.getAppUserEmail());
        password1.setAppUser(foundUser);
      Password createdPassword =  passwordServiceZ.createPassword(password1);
      foundUser.getListOfPasswords().add(createdPassword);
      foundUser.setNumberOfPasswords(foundUser.getListOfPasswords().size());
        return mapToAppUserResponse(appUserRepositoryZ.save(foundUser));
    }

    @Override
    public long countMyPassword(String mail) {
        return findAppUserByEmail(mail).getListOfPasswords().size();
    }

    @Override
    public AppUserResponse deletePasswordByLabel(String passwordLabel) {
        passwordServiceZ.deletePasswordByLabel( passwordLabel);
        return null;
    }

    @Override
    public Token generateAccessToken(String passwordLabel, String appUserEmail) {
        AppUser appUser = findAppUserByEmail(appUserEmail);
  Token token = passwordServiceZ.tokenGenerator(passwordLabel);
        appUser.setToken(token.getToken());
        appUserRepositoryZ.save(appUser);
        return token;
    }

    @Override
    public UnlockPassword getPasswordByLabel(String passwordLabel, String token) {
        Password foundPassword = passwordServiceZ.findPassword(passwordLabel);
        if (!foundPassword.getToken().equals(token)) return mapToUnlockPassword(foundPassword);
        foundPassword.setPassword(passwordServiceZ.decryptPassword(foundPassword.getPassword()));
        return mapToUnlockPassword(foundPassword);
    }
private UnlockPassword mapToUnlockPassword(Password password){
        return UnlockPassword.builder()
                .appUserEmail(password.getAppUserEmail())
                .token(password.getToken())
                .createdAt(password.getCreatedAt())
                .LastUpdatedAt(password.getLastUpdatedAt())
                .passwordLabel(password.getPasswordLabel())
                .password(password.getPassword())
                .build();
}



    private AppUserResponse mapToAppUserResponse(AppUser foundUser) {
        return AppUserResponse.builder()
                .userName(foundUser.getUserName())
                .numberOfPasswords(foundUser.getNumberOfPasswords())
                .build();
}
    private void ifEmailAlreadyExist(String emailAddress) {
        AppUser foundAppUser = appUserRepositoryZ.findByEmailAddress(emailAddress);
       if (foundAppUser!= null) throw new EmailAlreadyExistException("email already Exist");

    }
        private void passwordVerifier(String password) {
        int digit = 0;
        for (int i = 0; i <password.length() ; i++) {
            if (Character.isDigit(password.charAt(i))) digit ++;
        }
        if (digit < 3) throw new RegistrationException("invalid password At least password most contain 3 digit");
        }
        private AppUser mapRequestToAppUser(AppUserRequest appUserRequest){
        return AppUser.builder()
                .userName(appUserRequest.getUserName())
                .emailAddress(appUserRequest.getEmailAddress())
                .build();
        }
        private AppUserResponse mapAppUserToResponse(AppUser appUser){
        return AppUserResponse.builder()
                .userName(appUser.getUserName())
                .build();
        }

        public AppUser findAppUserByEmail(String email){
        AppUser foundAppUser = appUserRepositoryZ.findByEmailAddress(email);
            if (foundAppUser== null) throw new EmailAlreadyExistException("email already Exist");
            return foundAppUser;
        }





        }
