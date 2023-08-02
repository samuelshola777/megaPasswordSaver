package com.example.megaPassworkSaver.emailService.emailMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiverMailInfo {
  private   String receiverName;
  private  String receiverEmail;
}
