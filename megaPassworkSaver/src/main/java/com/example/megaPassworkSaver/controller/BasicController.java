package com.example.megaPassworkSaver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class BasicController {

    @GetMapping("/")
    public String home(Principal principal){

        return "my name is samuel shola";
    }


}
