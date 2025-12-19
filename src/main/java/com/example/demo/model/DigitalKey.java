package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "digital_keys", uniqueConstraints = @UniqueConstraint(columnNames = "keyValue"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DigitalKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private RoomBooking booking;

    @Column(nullable = false, unique = true)
    private String keyValue;

    private Timestamp issuedAt;

    private Timestamp expiresAt;

    private Boolean active = true;
}
