package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RoomBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long guestId;
    private String roomNumber;

    public RoomBooking() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // 🔥 REQUIRED
        this.id = id;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
