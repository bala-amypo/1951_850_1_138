package com.example.demo.controller;

import com.example.demo.dto.RoomBookingDTO;
import com.example.demo.model.RoomBooking;
import com.example.demo.service.RoomBookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class RoomBookingController {

    private final RoomBookingService bookingService;

    public RoomBookingController(RoomBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public RoomBooking create(@RequestBody RoomBookingDTO dto) {
        RoomBooking booking = new RoomBooking();
        booking.setRoomNumber(dto.getRoomNumber());
        booking.setCheckInDate(dto.getCheckInDate());
        booking.setCheckOutDate(dto.getCheckOutDate());
        return bookingService.createBooking(booking);
    }
}
