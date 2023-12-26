package com.example.springboot.controller;

import com.example.springboot.profile.SystemProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    private final SystemProfile profile;

    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("/")
    public String getIndex() {
        return "Welcome without authorization";
    }

    @GetMapping("/profile")
    public String getProfile() {
        return profile.getProfile();
    }
}

