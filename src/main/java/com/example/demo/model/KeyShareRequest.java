package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeyShareRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Key being shared
    @ManyToOne
    @JoinColumn(name = "digital_key_id", nullable = false)
    private DigitalKey digitalKey;

    // Owner of the key
    @ManyToOne
    @JoinColumn(name = "shared_by_id", nullable = false)
    private Guest sharedBy;

    // Guest receiving access
    @ManyToOne
    @JoinColumn(name = "shared_with_id", nullable = false)
    private Guest sharedWith;

    @Column(nullable = false)
    private Instant shareStart;

    @Column(nullable = false)
    private Instant shareEnd;

    private String status = "PENDING";

    private Instant createdAt = Instant.now();
}
