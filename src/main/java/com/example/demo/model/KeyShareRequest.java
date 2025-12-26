package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class KeyShareRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sharedById;
    private Long sharedWithId;
    private Long digitalKeyId;

    public KeyShareRequest() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // 🔥 REQUIRED
        this.id = id;
    }

    public Long getSharedById() {
        return sharedById;
    }

    public void setSharedById(Long sharedById) {
        this.sharedById = sharedById;
    }

    public Long getSharedWithId() {
        return sharedWithId;
    }

    public void setSharedWithId(Long sharedWithId) {
        this.sharedWithId = sharedWithId;
    }

    public Long getDigitalKeyId() {
        return digitalKeyId;
    }

    public void setDigitalKeyId(Long digitalKeyId) {
        this.digitalKeyId = digitalKeyId;
    }
}
