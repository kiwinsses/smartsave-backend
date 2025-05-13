package com.example.smartsave.controller;

import com.example.smartsave.model.User;
import com.example.smartsave.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login-or-register")
    public User loginOrRegister(@RequestParam String email,
                                @RequestParam String businessName) {
        return service.loginOrRegister(email, businessName);
    }

    @PostMapping("/setup-profile")
    public User setupSmartSaveProfile(@RequestParam String email,
                                      @RequestParam double percentage,
                                      @RequestParam double interestRate,
                                      @RequestParam double goalAmount) {
        return service.setupSmartSaveProfile(email, percentage, interestRate, goalAmount);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUser(id);
    }
}
