package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private DigitalKey digitalKey;

    private Instant accessTime;
    private String result;

    public AccessLog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public DigitalKey getDigitalKey() {
        return digitalKey;
    }

    public void setDigitalKey(DigitalKey digitalKey) {
        this.digitalKey = digitalKey;
    }

    public Instant getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Instant accessTime) {
        this.accessTime = accessTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {   // 🔥 REQUIRED
        this.result = result;
    }
}
