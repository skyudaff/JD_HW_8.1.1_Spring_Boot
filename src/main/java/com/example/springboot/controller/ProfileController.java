package com.example.springboot.controller;

import com.example.springboot.profile.SystemProfile;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Secured("ROLE_READ")
    @GetMapping("/secured")
    public String getSecuredRole() {
        return "READ ONLY";
    }

    @RolesAllowed("WRITE")
    @GetMapping("/roles-allow")
    public String getRolesAllow() {
        return "WRITE ONLY";
    }

    @PostAuthorize("hasAnyAuthority('ROLE_WRITE','ROLE_DELETE')")
    @GetMapping("/authorize")
    public String getPreAuthorize() {
        return "WRITE & DELETE";
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/user")
    public String getUsername(@RequestParam String username) {
        return String.format("Username \"%s\" is correct", username);
    }
}