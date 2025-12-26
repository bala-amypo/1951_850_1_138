package com.example.demo.repository;

import com.example.demo.model.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestRepository {

    Optional<Guest> findById(Long id);

    Optional<Guest> findByEmail(String email);

    boolean existsByEmail(String email);

    Guest save(Guest guest);

    List<Guest> findAll();
}
