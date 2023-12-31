package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.data.model.AppUser;
import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.data.model.Token;
import com.example.megaPassworkSaver.data.repository.AppUserRepositoryZ;
import com.example.megaPassworkSaver.dto.UnlockPassword;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.request.PageRequestDto;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import com.example.megaPassworkSaver.dto.response.PasswordResponse;
import com.example.megaPassworkSaver.exception.EmailAlreadyExistException;
import com.example.megaPassworkSaver.exception.PasswordException;
import com.example.megaPassworkSaver.exception.RegistrationException;
import com.example.megaPassworkSaver.service.AppUserService;
import com.example.megaPassworkSaver.service.EmailService;
import com.example.megaPassworkSaver.service.PasswordServiceZ;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepositoryZ appUserRepositoryZ;

    private final   PasswordServiceZ passwordServiceZ;
    private final EmailService emailService;

    @Override
    public AppUserResponse registerNewUser(AppUserRequest appUserRequest3) {
        ifEmailAlreadyExist(appUserRequest3.getEmailAddress());
      //  passwordVerifier(appUserRequest3.getUnlockPassword());
        AppUser mappedAppUser = mapRequestToAppUser(appUserRequest3);
        emailService.sendSimpleMailMessage(appUserRequest3.getUserName(), appUserRequest3.getEmailAddress(),"you are a goat");
     try {
         return mapAppUserToResponse(appUserRepositoryZ.save(mappedAppUser));
     }catch (DataIntegrityViolationException e){
         throw new RegistrationException("Email address "+appUserRequest3.getEmailAddress()+" is already or username "+appUserRequest3.getUserName()+" is already");
     }

    }

    @Override
    public long countUsers() {
        return appUserRepositoryZ.count();
    }

    @Override
    public AppUserResponse userSavePassword(Password password1) {
        if (password1.getAppUserEmail() == null) throw new PasswordException("please provide a user email");
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
        log.info("i got here 1");
        Password foundPassword = passwordServiceZ.findPassword(passwordLabel);
        log.info("i got here");
     if (! foundPassword.getAppUser().getToken().equals(token))  return passwordServiceZ.mapToUnlockPasswordWithWrongToken(foundPassword);
     return passwordServiceZ. mapToUnlockPassword(foundPassword);
    }

    @Override
    public long deleteAllPassword(String mail, String myGithubPassword) {
  findAppUserByEmail(mail).getListOfPasswords().removeAll(findAppUserByEmail(mail).getListOfPasswords());
        return findAppUserByEmail(mail).getListOfPasswords().size();
    }

    @Override
    public Page<UnlockPassword> getAllPassword(PageRequestDto pageRequestDto) {
        if (!findAppUserByEmail(pageRequestDto.getAppUserEmail()).getToken().equals(pageRequestDto.getToken())) return passwordServiceZ.viewAllPasswordWithWrongToken(pageRequestDto);
        return passwordServiceZ.viewAllPassword(pageRequestDto);
    }




    private AppUserResponse mapToAppUserResponse(AppUser foundUser) {
        return AppUserResponse.builder()
                .userName(foundUser.getUsername())
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
                .unlockPassword(appUserRequest.getUnlockPassword())
                .build();
        }
        private AppUserResponse mapAppUserToResponse(AppUser appUser){
        return AppUserResponse.builder()
                .numberOfPasswords(appUser.getListOfPasswords().size())
                .userName(appUser.getUsername())
                .build();
        }

        public AppUser findAppUserByEmail(String email){
        AppUser foundAppUser = appUserRepositoryZ.findByEmailAddress(email);
            if (foundAppUser== null) throw new EmailAlreadyExistException("email does  not exist");
            return foundAppUser;
        }

    @Override
    public String deleteAppUserAccountByEmail(String email) {
        appUserRepositoryZ.delete(appUserRepositoryZ.findByEmailAddress(email));
        return "Delete successfully";
    }


}
