package com.example.demo.repository;

import com.example.demo.model.RoomBooking;

import java.util.List;
import java.util.Optional;

public interface RoomBookingRepository {

    RoomBooking save(RoomBooking booking);

    Optional<RoomBooking> findById(Long id);

    List<RoomBooking> findByGuestId(Long guestId);
}
