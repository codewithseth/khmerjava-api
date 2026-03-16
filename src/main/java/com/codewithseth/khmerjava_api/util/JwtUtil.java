package com.codewithseth.khmerjava_api.util;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.codewithseth.khmerjava_api.constant.AppConstants;
import com.codewithseth.khmerjava_api.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final Environment env;

    public String generateJwtToken(Authentication authentication) {
        String jwt = "";
        
        String secret = env.getProperty(AppConstants.JWT_SECRET_KEY, AppConstants.JWT_SECRET_DEFAULT_VALUE);
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        User user = (User) authentication.getPrincipal();

        jwt = Jwts.builder().issuer("KhmerJavaAPI").subject("JWT Token")
            .claim("email", user.getEmail())
            .claim("roles", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
            .issuedAt(new java.util.Date())
            .expiration(new java.util.Date((new java.util.Date()).getTime() + 24 * 60 * 60 * 1000)) // 24 hours
            .signWith(secretKey).compact();

        return jwt;
    }

}
