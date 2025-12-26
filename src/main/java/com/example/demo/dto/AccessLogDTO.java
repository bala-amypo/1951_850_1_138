package com.example.demo.dto;

import lombok.Data;
import java.time.Instant;

@Data
public class AccessLogDTO {
    private Long id;
    private Long digitalKeyId;
    private Long guestId;
    private Instant accessTime;
    private String result;
    private String reason;
}
