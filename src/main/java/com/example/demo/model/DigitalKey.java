package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DigitalKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each key belongs to one booking
    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private RoomBooking booking;

    @Column(nullable = false, unique = true)
    private String keyValue;

    @Column(nullable = false)
    private Instant issuedAt;

    @Column(nullable = false)
    private Instant expiresAt;

    private Boolean active = true;
}
