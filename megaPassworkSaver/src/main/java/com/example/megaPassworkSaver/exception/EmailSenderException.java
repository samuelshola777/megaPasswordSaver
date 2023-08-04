package com.example.megaPassworkSaver.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailSenderException extends RuntimeException{
    private String message;
}
