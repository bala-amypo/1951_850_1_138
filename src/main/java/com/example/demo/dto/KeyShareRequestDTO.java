package com.example.demo.dto;

import lombok.Data;
import java.time.Instant;

@Data
public class KeyShareRequestDTO {
    private Long id;
    private Long digitalKeyId;
    private Long sharedById;
    private Long sharedWithId;
    private Instant shareStart;
    private Instant shareEnd;
    private String status;
}
