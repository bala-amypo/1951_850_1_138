package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RoomBooking;
import com.example.demo.repository.RoomBookingRepository;
import com.example.demo.service.RoomBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

    private final RoomBookingRepository bookingRepository;

    public RoomBookingServiceImpl(RoomBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public RoomBooking createBooking(RoomBooking booking) {
        if (!booking.getCheckInDate().isBefore(booking.getCheckOutDate())) {
            throw new IllegalArgumentException("Check-in");
        }
        return bookingRepository.save(booking);
    }

    @Override
    public RoomBooking updateBooking(Long id, RoomBooking booking) {
        RoomBooking existing = getBookingById(id);

        if (!booking.getCheckInDate().isBefore(booking.getCheckOutDate())) {
            throw new IllegalArgumentException("Check-in");
        }

        existing.setRoomNumber(booking.getRoomNumber());
        existing.setCheckInDate(booking.getCheckInDate());
        existing.setCheckOutDate(booking.getCheckOutDate());
        existing.setActive(booking.getActive());

        return bookingRepository.save(existing);
    }

    @Override
    public RoomBooking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
    }

    @Override
    public List<RoomBooking> getBookingsForGuest(Long guestId) {
        return bookingRepository.findByGuestId(guestId);
    }

    @Override
    public void deactivateBooking(Long id) {
        RoomBooking booking = getBookingById(id);
        booking.setActive(false);
        bookingRepository.save(booking);
    }
}
