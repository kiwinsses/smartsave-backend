package com.example.smartsave.service;

import com.example.smartsave.model.SmartSaveProfile;
import com.example.smartsave.model.User;
import com.example.smartsave.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User loginOrRegister(String email, String businessName) {
        if (repo.existsByEmail(email)) {
            return repo.findByEmail(email);
        }

        User user = new User();
        user.setEmail(email);
        user.setBusinessName(businessName);

        return repo.save(user);
    }

    public User setupSmartSaveProfile(String email, double percentage, double interestRate, double goalAmount) {
        if (percentage < 0 || interestRate < 0 || goalAmount <= 0) {
            throw new IllegalArgumentException("Invalid SmartSave profile configuration.");
        }

        User user = repo.findByEmail(email);
        if (user == null) throw new IllegalArgumentException("User not found.");

        SmartSaveProfile profile = new SmartSaveProfile();
        profile.setSavingsPercentage(percentage);
        profile.setInterestRate(interestRate);
        profile.setStartDate(new Date());
        profile.setGoalAmount(goalAmount);

        user.setSmartSaveProfile(profile);
        return repo.save(user);
    }

    public User getUser(Long id) {
        return repo.findById(id).orElse(null);
    }
}