package com.example.demo.repository;

import com.example.demo.model.DigitalKey;

import java.util.List;
import java.util.Optional;

public interface DigitalKeyRepository {

    DigitalKey save(DigitalKey key);

    Optional<DigitalKey> findById(Long id);

    Optional<DigitalKey> findByBookingIdAndActiveTrue(Long bookingId);

    List<DigitalKey> findByBookingGuestId(Long guestId);
}
