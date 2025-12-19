package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "key_share_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KeyShareRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "digital_key_id")
    private DigitalKey digitalKey;

    @ManyToOne
    @JoinColumn(name = "shared_by")
    private Guest sharedBy;

    @ManyToOne
    @JoinColumn(name = "shared_with")
    private Guest sharedWith;

    private Timestamp shareStart;

    private Timestamp shareEnd;

    private String status = "PENDING";

    private Timestamp createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
