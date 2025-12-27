// =====================================================
// FILE: JwtTokenProvider.java
// PACKAGE: com.example.demo.security
// PURPOSE: JWT creation + validation (TEST DEPENDS ON THIS)
// =====================================================

package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final SecretKey secretKey;
    private final long validityInMs;

    public JwtTokenProvider(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.validity}") long validityInMs
    ) {
        this.secretKey = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8));
        this.validityInMs = validityInMs;
    }

    public String generateToken(Authentication authentication) {
        GuestPrincipal principal = (GuestPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(String.valueOf(principal.getId()))
                .claim("email", principal.getUsername())
                .claim("role", principal.getAuthorities()
                        .iterator().next().getAuthority())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Long getUserIdFromToken(String token) {
        return Long.parseLong(getClaims(token).getSubject());
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).get("email", String.class);
    }

    public String getRoleFromToken(String token) {
        return getClaims(token).get("role", String.class);
    }
}
