package com.example.demo.controllers;

import com.example.demo.data_access.ApplicationUserRepository;
import com.example.demo.models.ApplicationUser;
import com.example.demo.models.SignUpInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users/")
public class ApplicationUserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUserController(ApplicationUserRepository applicationUserRepository,
                                     BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/")
    public void signUp(@RequestBody SignUpInfo signUpInfo) {
        ApplicationUser user = new ApplicationUser();
        user.setEmail(signUpInfo.getEmail());
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(signUpInfo.getPassword()));
        applicationUserRepository.save(user);
    }
}