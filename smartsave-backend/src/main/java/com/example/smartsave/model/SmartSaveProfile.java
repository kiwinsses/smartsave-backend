package com.example.smartsave.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SmartSaveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    double savingsPercentage;
    double interestRate;

    @Temporal(TemporalType.TIMESTAMP)
    Date startDate;

    double goalAmount;
}