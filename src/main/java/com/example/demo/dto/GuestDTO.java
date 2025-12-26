package com.example.demo.dto;

import lombok.Data;

@Data
public class GuestDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Boolean verified;
    private Boolean active;
    private String role;
}
