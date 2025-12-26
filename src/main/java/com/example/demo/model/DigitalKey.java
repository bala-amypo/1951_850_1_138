package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DigitalKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;
    private boolean active;

    public DigitalKey() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // 🔥 REQUIRED
        this.id = id;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
