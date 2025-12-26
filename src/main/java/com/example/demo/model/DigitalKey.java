package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DigitalKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RoomBooking booking;

    private boolean active;

    public DigitalKey() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomBooking getBooking() {
        return booking;
    }

    public void setBooking(RoomBooking booking) {   // 🔥 REQUIRED
        this.booking = booking;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
