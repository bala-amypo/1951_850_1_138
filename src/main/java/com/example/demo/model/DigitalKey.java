package com.example.demo.model;

import java.time.Instant;

public class DigitalKey {

    private Long id;
    private String keyValue;
    private Instant issuedAt;
    private Instant expiresAt;
    private boolean active;
    private RoomBooking booking;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKeyValue() { return keyValue; }
    public void setKeyValue(String keyValue) { this.keyValue = keyValue; }

    public Instant getIssuedAt() { return issuedAt; }
    public void setIssuedAt(Instant issuedAt) { this.issuedAt = issuedAt; }

    public Instant getExpiresAt() { return expiresAt; }
    public void setExpiresAt(Instant expiresAt) { this.expiresAt = expiresAt; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public RoomBooking getBooking() { return booking; }
    public void setBooking(RoomBooking booking) { this.booking = booking; }
}
