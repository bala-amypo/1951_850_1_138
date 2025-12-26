package com.example.demo.controller;

import com.example.demo.dto.KeyShareRequestDTO;
import com.example.demo.model.KeyShareRequest;
import com.example.demo.service.KeyShareRequestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shares")
public class KeyShareRequestController {

    private final KeyShareRequestService service;

    public KeyShareRequestController(KeyShareRequestService service) {
        this.service = service;
    }

    @PostMapping
    public KeyShareRequest share(@RequestBody KeyShareRequestDTO dto) {
        KeyShareRequest req = new KeyShareRequest();
        req.setDigitalKey(dto.getDigitalKey());
        req.setSharedBy(dto.getSharedBy());
        req.setSharedWith(dto.getSharedWith());
        req.setShareStart(dto.getShareStart());
        req.setShareEnd(dto.getShareEnd());
        return service.createShareRequest(req);
    }
}
