package com.example.demo.repository;

import com.example.demo.model.AccessLog;

import java.util.List;

public interface AccessLogRepository {

    AccessLog save(AccessLog log);

    List<AccessLog> findByGuestId(Long guestId);

    List<AccessLog> findByDigitalKeyId(Long keyId);
}
