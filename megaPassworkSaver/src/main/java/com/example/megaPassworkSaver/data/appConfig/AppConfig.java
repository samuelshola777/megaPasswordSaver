package com.example.megaPassworkSaver.data.appConfig;

import com.example.megaPassworkSaver.data.repository.AppUserRepositoryZ;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Transactional
public class AppConfig {

//    @Bean
//public TokenRepository tokenRepository(){
//        return  TokenRepository();
//    }
@Bean
    public void appUserRepository() {
        AppUserRepositoryZ appUserRepositoryZ;
    }
}
