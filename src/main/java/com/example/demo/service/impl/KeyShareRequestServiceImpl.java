package com.example.demo.service.impl;

import com.example.demo.model.KeyShareRequest;
import com.example.demo.repository.DigitalKeyRepository;
import com.example.demo.repository.GuestRepository;
import com.example.demo.repository.KeyShareRequestRepository;
import com.example.demo.service.KeyShareRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyShareRequestServiceImpl implements KeyShareRequestService {

    private final KeyShareRequestRepository repository;
    private final DigitalKeyRepository digitalKeyRepository;
    private final GuestRepository guestRepository;

    public KeyShareRequestServiceImpl(
            KeyShareRequestRepository repository,
            DigitalKeyRepository digitalKeyRepository,
            GuestRepository guestRepository) {
        this.repository = repository;
        this.digitalKeyRepository = digitalKeyRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public KeyShareRequest createShareRequest(KeyShareRequest request) {

        if (request.getSharedBy().equals(request.getSharedWith())) {
            throw new IllegalArgumentException(
                    "sharedBy and sharedWith cannot be same");
        }

        if (request.getShareEnd().isBefore(request.getShareStart())) {
            throw new IllegalArgumentException(
                    "Share end must be after share start");
        }

        return repository.save(request);
    }

    @Override
    public List<KeyShareRequest> getRequestsSharedBy(Long guestId) {
        return repository.findBySharedById(guestId);
    }

    @Override
    public List<KeyShareRequest> getRequestsSharedWith(Long guestId) {
        return repository.findBySharedWithId(guestId);
    }
}
