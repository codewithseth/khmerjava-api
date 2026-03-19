package com.codewithseth.khmerjava_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithseth.khmerjava_api.dto.ProfileDto;
import com.codewithseth.khmerjava_api.dto.ProfileRequestDto;
import com.codewithseth.khmerjava_api.service.IProfileService;

import jakarta.validation.Valid;
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

    @PutMapping
    public ResponseEntity<ProfileDto> updateUserProfile(@Valid @RequestBody ProfileRequestDto profileRequestDto) {
        ProfileDto updatedProfile = iProfileService.updateProfile(profileRequestDto);
        return ResponseEntity.ok(updatedProfile);
    }

}
