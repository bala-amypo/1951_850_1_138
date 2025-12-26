package com.example.demo.controller;

import com.example.demo.model.DigitalKey;
import com.example.demo.service.DigitalKeyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/keys")
public class DigitalKeyController {

    private final DigitalKeyService digitalKeyService;

    public DigitalKeyController(DigitalKeyService digitalKeyService) {
        this.digitalKeyService = digitalKeyService;
    }

    @PostMapping("/{bookingId}")
    public DigitalKey generate(@PathVariable Long bookingId) {
        return digitalKeyService.generateKey(bookingId);
    }
}
