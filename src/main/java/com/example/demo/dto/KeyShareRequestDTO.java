package com.example.demo.dto;

import com.example.demo.model.DigitalKey;
import com.example.demo.model.Guest;

import java.time.Instant;

public class KeyShareRequestDTO {

    private DigitalKey digitalKey;
    private Guest sharedBy;
    private Guest sharedWith;
    private Instant shareStart;
    private Instant shareEnd;

    public DigitalKey getDigitalKey() {
        return digitalKey;
    }

    public void setDigitalKey(DigitalKey digitalKey) {
        this.digitalKey = digitalKey;
    }

    public Guest getSharedBy() {
        return sharedBy;
    }

    public void setSharedBy(Guest sharedBy) {
        this.sharedBy = sharedBy;
    }

    public Guest getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(Guest sharedWith) {
        this.sharedWith = sharedWith;
    }

    public Instant getShareStart() {
        return shareStart;
    }

    public void setShareStart(Instant shareStart) {
        this.shareStart = shareStart;
    }

    public Instant getShareEnd() {
        return shareEnd;
    }

    public void setShareEnd(Instant shareEnd) {
        this.shareEnd = shareEnd;
    }
}
