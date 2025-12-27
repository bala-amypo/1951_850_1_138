package com.example.demo.dto;

import com.example.demo.model.DigitalKey;
import com.example.demo.model.Guest;

import java.time.Instant;

public class AccessLogDTO {

    private DigitalKey digitalKey;
    private Guest guest;
    private Instant accessTime;

    public DigitalKey getDigitalKey() {
        return digitalKey;
    }

    public void setDigitalKey(DigitalKey digitalKey) {
        this.digitalKey = digitalKey;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Instant getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Instant accessTime) {
        this.accessTime = accessTime;
    }
}
