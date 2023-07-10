package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.data.repository.AppUserRepository;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import com.example.megaPassworkSaver.exception.EmailAlreadyExistException;
import com.example.megaPassworkSaver.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    @Override
    public AppUserResponse registerNewUser(AppUserRequest appUserRequest3) {
        ifEmailAlreadyExist(appUserRequest3.getEmailAddress());

        return null;
    }
    private void ifEmailAlreadyExist(String emailAddress) {
       if (!appUserRepository.findByEmailAddress(emailAddress)) throw new EmailAlreadyExistException("email already Exist");

    }
    private void passwordVerifier(String password) {

    }

}
