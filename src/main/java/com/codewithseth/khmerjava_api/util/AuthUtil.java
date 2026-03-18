package com.codewithseth.khmerjava_api.util;

import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public final class AuthUtil {

    private AuthUtil() {}

    public static String authorityListToCommaSeparatedString(Authentication authentication) {
        if (authentication == null || authentication.getAuthorities() == null) return "";
        return authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));
    }

}
