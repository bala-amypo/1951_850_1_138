package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.AccessLogService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AccessLogServiceImpl implements AccessLogService {

    private final AccessLogRepository accessLogRepository;
    private final DigitalKeyRepository digitalKeyRepository;
    private final GuestRepository guestRepository;
    private final KeyShareRequestRepository keyShareRequestRepository;

    public AccessLogServiceImpl(
            AccessLogRepository accessLogRepository,
            DigitalKeyRepository digitalKeyRepository,
            GuestRepository guestRepository,
            KeyShareRequestRepository keyShareRequestRepository) {

        this.accessLogRepository = accessLogRepository;
        this.digitalKeyRepository = digitalKeyRepository;
        this.guestRepository = guestRepository;
        this.keyShareRequestRepository = keyShareRequestRepository;
    }

    @Override
    public AccessLog createLog(AccessLog log) {

        // ❌ Future time not allowed
        if (log.getAccessTime().isAfter(Instant.now())) {
            throw new IllegalArgumentException("Access time cannot be in the future");
        }

        DigitalKey key = digitalKeyRepository.findById(
                log.getDigitalKey().getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Digital key not found"));

        Guest guest = guestRepository.findById(
                log.getGuest().getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Guest not found"));

        boolean allowed = false;

        // Case 1: Owner of booking
        if (key.getBooking().getGuest().getId().equals(guest.getId())) {
            allowed = true;
        }

        // Case 2: Shared key access
        if (!allowed) {
            boolean hasShare = keyShareRequestRepository
                    .findBySharedWithId(guest.getId())
                    .stream()
                    .anyMatch(req ->
                            req.getDigitalKey().getId().equals(key.getId()) &&
                            req.getShareStart().isBefore(log.getAccessTime()) &&
                            req.getShareEnd().isAfter(log.getAccessTime()));
            allowed = hasShare;
        }

        // Key validity check
        if (!key.getActive()
                || log.getAccessTime().isBefore(key.getIssuedAt())
                || log.getAccessTime().isAfter(key.getExpiresAt())) {
            allowed = false;
        }

        log.setDigitalKey(key);
        log.setGuest(guest);

        if (allowed) {
            log.setResult("SUCCESS");
        } else {
            log.setResult("DENIED");
        }

        return accessLogRepository.save(log);
    }

    @Override
    public List<AccessLog> getLogsForGuest(Long guestId) {
        return accessLogRepository.findByGuestId(guestId);
    }

    @Override
    public List<AccessLog> getLogsForKey(Long keyId) {
        return accessLogRepository.findByDigitalKeyId(keyId);
    }
}
