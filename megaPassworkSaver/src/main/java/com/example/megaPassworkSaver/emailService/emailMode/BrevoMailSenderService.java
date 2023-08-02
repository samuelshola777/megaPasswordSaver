package com.example.megaPassworkSaver.emailService.emailMode;

import com.example.megaPassworkSaver.emailService.BrevoEmailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrevoMailSenderService {
//    private final WebClient.Builder webClient;
//    @Value("${brevo_api_key}")
//    private String BREVO_API_KEY;


//    @Async        //this method sends email to user
// user   public void sendMail(BrevoEmailRequest emailRequest) {
//        emailRequest.setSender(new MailInfo(appName, appEmail));
//
//        webClient
//                .baseUrl(mailUrl)
//                .defaultHeader("api-key", BREVO_API_KEY)
//                .build()
//                .post()
//                .bodyValue(emailRequest)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//    }
}
