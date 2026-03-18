package com.codewithseth.khmerjava_api.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.codewithseth.khmerjava_api.entity.User;
import com.codewithseth.khmerjava_api.util.AuthUtil;

import java.util.Optional;

@Component("auditorAwareImpl")
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = AuthUtil.getCurrentAuthentication();

        if (authentication == null ||
            !authentication.isAuthenticated() ||
            authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.of("Anonymous user");
        }

        Object principal = authentication.getPrincipal();
        String username;

        if (principal instanceof User user) {
            username = user.getEmail();
        } else {
            username = principal.toString();
        }

        return Optional.of(username);
    }

}
