package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.KeyShareRequestService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class KeyShareRequestServiceImpl implements KeyShareRequestService {

    private final KeyShareRequestRepository keyShareRequestRepository;
    private final DigitalKeyRepository digitalKeyRepository;
    private final GuestRepository guestRepository;

    public KeyShareRequestServiceImpl(
            KeyShareRequestRepository keyShareRequestRepository,
            DigitalKeyRepository digitalKeyRepository,
            GuestRepository guestRepository) {

        this.keyShareRequestRepository = keyShareRequestRepository;
        this.digitalKeyRepository = digitalKeyRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public KeyShareRequest createShareRequest(KeyShareRequest request) {

        DigitalKey key = digitalKeyRepository.findById(
                request.getDigitalKey().getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Digital key not found"));

        Guest sharedBy = guestRepository.findById(
                request.getSharedBy().getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("SharedBy guest not found"));

        Guest sharedWith = guestRepository.findById(
                request.getSharedWith().getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("SharedWith guest not found"));

        // ❌ Cannot share with self
        if (sharedBy.getId().equals(sharedWith.getId())) {
            throw new IllegalArgumentException(
                    "sharedBy and sharedWith cannot be the same");
        }

        // ❌ Invalid time range
        if (request.getShareEnd().isBefore(request.getShareStart())) {
            throw new IllegalArgumentException(
                    "Share end time must be after share start");
        }

        request.setDigitalKey(key);
        request.setSharedBy(sharedBy);
        request.setSharedWith(sharedWith);
        request.setStatus("APPROVED");

        return keyShareRequestRepository.save(request);
    }

    @Override
    public List<KeyShareRequest> getRequestsSharedBy(Long guestId) {
        return keyShareRequestRepository.findBySharedById(guestId);
    }

    @Override
    public List<KeyShareRequest> getRequestsSharedWith(Long guestId) {
        return keyShareRequestRepository.findBySharedWithId(guestId);
    }
}
