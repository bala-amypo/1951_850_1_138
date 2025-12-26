package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long guestId;
    private Long digitalKeyId;

    public AccessLog() {}

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

    public Long getDigitalKeyId() {
        return digitalKeyId;
    }

    public void setDigitalKeyId(Long digitalKeyId) {
        this.digitalKeyId = digitalKeyId;
    }
}
