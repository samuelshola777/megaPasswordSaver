package com.example.megaPassworkSaver.emailService;

import com.example.megaPassworkSaver.emailService.emailMode.MailInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrevoEmailRequest {
    private MailInfo sender;
    private List<MailInfo> to;

    private String subject;

    private String htmlContent;
}
