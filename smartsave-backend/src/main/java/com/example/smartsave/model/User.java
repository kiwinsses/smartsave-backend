package com.example.smartsave.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // from myPOS (use merchantId or email as fallback)

    private String email;
    private String businessName;

    @OneToOne(cascade = CascadeType.ALL)
    private SmartSaveProfile smartSaveProfile;
}
