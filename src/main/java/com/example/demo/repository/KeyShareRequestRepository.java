package com.example.demo.repository;

import com.example.demo.model.KeyShareRequest;

import java.util.List;

public interface KeyShareRequestRepository {

    KeyShareRequest save(KeyShareRequest request);

    List<KeyShareRequest> findBySharedWithId(Long guestId);

    List<KeyShareRequest> findBySharedById(Long guestId);
}
