package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class RoomBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Guest guest;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean active;

    public RoomBooking() {}

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

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isActive() {             // 🔥 REQUIRED
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
