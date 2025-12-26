package com.example.demo.service.impl;

import com.example.demo.model.KeyShareRequest;
import com.example.demo.repository.DigitalKeyRepository;
import com.example.demo.repository.GuestRepository;
import com.example.demo.repository.KeyShareRequestRepository;
import com.example.demo.service.KeyShareRequestService;

import java.util.List;

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

        // ❌ sharedBy and sharedWith must not be same
        if (request.getSharedBy().equals(request.getSharedWith())) {
            throw new IllegalArgumentException(
                    "sharedBy and sharedWith cannot be same");
        }

        // ❌ shareEnd must be after shareStart
        if (request.getShareEnd().isBefore(request.getShareStart())) {
            throw new IllegalArgumentException(
                    "Share end must be after share start");
        }

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
