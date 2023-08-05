package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.data.model.AppUser;
import com.example.megaPassworkSaver.data.model.Confirmation;
import com.example.megaPassworkSaver.data.repository.AppUserRepositoryZ;
import com.example.megaPassworkSaver.data.repository.ConfirmationRepository;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.exception.AppUserException;
import com.example.megaPassworkSaver.service.EmailService;
import com.example.megaPassworkSaver.service.JustUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JustUserServiceIMPL implements JustUserService {
    private final AppUserRepositoryZ userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final EmailService emailService;
    @Override
    public AppUser registerUser(AppUser appUser) {
        if (userRepository.existsByEmailAddress(appUser.getEmailAddress())) throw  new AppUserException("account already exists");
      appUser.setEnabled(false);
         userRepository.save(appUser);
        Confirmation confirmation = new Confirmation(appUser);
        confirmationRepository.save(confirmation);
        // TODO send email/token to user
        emailService.sendSimpleMailMessage(appUser.getUsername(), appUser.getEmailAddress(), appUser.getToken());
        return appUser;
    }

    @Override
    public Boolean verifyToken(String token) {
        AppUser appUser = userRepository.findByEmailAddress(confirmationRepository.findByTokenC(token).getAppUser().getEmailAddress());
        if (appUser != null) throw new AppUserException("user does nt exi");
       appUser.setEnabled(true);
       userRepository.save( appUser);
        return Boolean.TRUE;
    }
}
