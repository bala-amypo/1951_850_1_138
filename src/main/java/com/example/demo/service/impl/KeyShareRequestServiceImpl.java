package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DigitalKey;
import com.example.demo.model.Guest;
import com.example.demo.model.KeyShareRequest;
import com.example.demo.repository.DigitalKeyRepository;
import com.example.demo.repository.GuestRepository;
import com.example.demo.repository.KeyShareRequestRepository;
import com.example.demo.service.KeyShareRequestService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class KeyShareRequestServiceImpl implements KeyShareRequestService {

    private final KeyShareRequestRepository keyShareRequestRepository;
    private final DigitalKeyRepository digitalKeyRepository;
    private final GuestRepository guestRepository;

    public KeyShareRequestServiceImpl(KeyShareRequestRepository keyShareRequestRepository,
                                      DigitalKeyRepository digitalKeyRepository,
                                      GuestRepository guestRepository) {
        this.keyShareRequestRepository = keyShareRequestRepository;
        this.digitalKeyRepository = digitalKeyRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public KeyShareRequest createShareRequest(KeyShareRequest request) {

        if (request.getShareEnd().isBefore(request.getShareStart())) {
            throw new IllegalArgumentException("Share end must be after share start");
        }

        if (request.getSharedBy().getId().equals(request.getSharedWith().getId())) {
            throw new IllegalArgumentException("sharedBy and sharedWith must be different");
        }

        DigitalKey key = digitalKeyRepository.findById(request.getDigitalKey().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Key not found"));

        Guest recipient = guestRepository.findById(request.getSharedWith().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found"));

        if (!recipient.isVerified() || !recipient.getActive()) {
            throw new IllegalStateException("Recipient not eligible");
        }

        request.setStatus("PENDING");
        return keyShareRequestRepository.save(request);
    }

    @Override
    public KeyShareRequest updateStatus(Long requestId, String status) {
        KeyShareRequest req = getShareRequestById(requestId);
        req.setStatus(status);
        return keyShareRequestRepository.save(req);
    }

    @Override
    public KeyShareRequest getShareRequestById(Long id) {
        return keyShareRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Share request not found: " + id));
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
