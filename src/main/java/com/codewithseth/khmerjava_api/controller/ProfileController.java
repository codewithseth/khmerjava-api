package com.codewithseth.khmerjava_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithseth.khmerjava_api.dto.ProfileDto;
import com.codewithseth.khmerjava_api.service.IProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final IProfileService iProfileService;

    @GetMapping
    public ResponseEntity<ProfileDto> findUserProfile() {
        ProfileDto profileDto = iProfileService.getProfile();
        return ResponseEntity.ok(profileDto);
    }

}
