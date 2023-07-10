package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.data.repository.AppUserRepository;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import com.example.megaPassworkSaver.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    @Override
    public AppUserResponse registerNewUser(AppUserRequest appUserRequest3) {

        return null;
    }
    private boolean ifEmailAlreadyExist(String emailAddress) {
       if (!appUserRepository.findByEmailAddress(emailAddress)) return true;
       return false;
    }
}
