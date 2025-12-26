package com.example.demo.dto;

import lombok.Data;
import java.time.Instant;

@Data
public class DigitalKeyDTO {
    private Long id;
    private String keyValue;
    private Instant issuedAt;
    private Instant expiresAt;
    private Boolean active;
}
