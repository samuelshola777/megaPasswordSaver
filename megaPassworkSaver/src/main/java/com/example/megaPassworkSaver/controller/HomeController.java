package com.example.megaPassworkSaver.controller;

import com.example.megaPassworkSaver.data.model.FacebookPost;
import com.example.megaPassworkSaver.service.FacebookService;
import facebook4j.Facebook;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@RequiredArgsConstructor
@RestController
//@RequestMapping("/api")
public class HomeController {
    Facebook
//private final FacebookService facebookService;

    @GetMapping("/")
    public String home() {
        return "home made food";
    }
    @GetMapping("/secured")
    public String secured() {
       // facebookService.postToFacebook(post);
        return "i am  secured";
    }
}
