package com.example.demo.controller;

import com.example.demo.dto.GuestRequestDTO;
import com.example.demo.model.Guest;
import com.example.demo.service.GuestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public Guest createGuest(@RequestBody GuestRequestDTO dto) {
        Guest g = new Guest();
        g.setEmail(dto.getEmail());
        g.setPassword(dto.getPassword());
        g.setFullName(dto.getFullName());
        return guestService.createGuest(g);
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }
}
