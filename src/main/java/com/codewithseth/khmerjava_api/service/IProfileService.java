package com.codewithseth.khmerjava_api.service;

import com.codewithseth.khmerjava_api.dto.ProfileDto;
import com.codewithseth.khmerjava_api.dto.ProfileRequestDto;

public interface IProfileService {
    ProfileDto getProfile();
    ProfileDto updateProfile(ProfileRequestDto profileRequestDto);
}
