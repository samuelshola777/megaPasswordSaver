package com.example.megaPassworkSaver.exception;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class PasswordException extends RuntimeException{
   private String message;
   public PasswordException(String message){
      super(message);
   }
}
