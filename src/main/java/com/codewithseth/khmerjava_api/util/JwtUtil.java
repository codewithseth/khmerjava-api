package com.codewithseth.khmerjava_api.util;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.codewithseth.khmerjava_api.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    public String generateJwtToken(Authentication authentication) {
        String jwt = "";
        String secret = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";

        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        User user = (User) authentication.getPrincipal();

        jwt = Jwts.builder().issuer("KhmerJavaAPI").subject("JWT Token")
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .claim("roles", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                .issuedAt(new java.util.Date())
                .expiration(new java.util.Date((new java.util.Date()).getTime() + 24 * 60 * 60 * 1000)) // 24 hours
                .signWith(secretKey).compact();

        return jwt;
    }

}
