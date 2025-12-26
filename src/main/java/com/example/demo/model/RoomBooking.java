package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

public class RoomBooking {

    private Long id;
    private String roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Guest guest;
    private List<Guest> roommates;
    private boolean active;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }

    public LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }

    public Guest getGuest() { return guest; }
    public void setGuest(Guest guest) { this.guest = guest; }

    public List<Guest> getRoommates() { return roommates; }
    public void setRoommates(List<Guest> roommates) { this.roommates = roommates; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
