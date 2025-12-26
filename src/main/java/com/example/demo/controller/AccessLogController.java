package com.example.demo.controller;

import com.example.demo.dto.AccessLogDTO;
import com.example.demo.model.AccessLog;
import com.example.demo.service.AccessLogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
public class AccessLogController {

    private final AccessLogService service;

    public AccessLogController(AccessLogService service) {
        this.service = service;
    }

    @PostMapping
    public AccessLog create(@RequestBody AccessLogDTO dto) {
        AccessLog log = new AccessLog();
        log.setDigitalKey(dto.getDigitalKey());
        log.setGuest(dto.getGuest());
        log.setAccessTime(dto.getAccessTime());
        return service.createLog(log);
    }
}
