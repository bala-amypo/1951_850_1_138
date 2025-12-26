package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
public class RoomBookingDTO {
    private Long id;
    private String roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Boolean active;
    private Set<Long> roommateIds;
}
