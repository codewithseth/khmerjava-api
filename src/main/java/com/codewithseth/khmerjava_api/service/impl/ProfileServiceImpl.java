package com.codewithseth.khmerjava_api.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithseth.khmerjava_api.dto.ProfileDto;
import com.codewithseth.khmerjava_api.entity.User;
import com.codewithseth.khmerjava_api.repository.UserRepository;
import com.codewithseth.khmerjava_api.service.IProfileService;
import com.codewithseth.khmerjava_api.util.AuthUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements IProfileService {

    private final UserRepository userRepository;

    @Override
    public ProfileDto getProfile() {
        Authentication authentication = AuthUtil.getCurrentAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(
            () -> new UsernameNotFoundException("User not found")
        );

        ProfileDto profileDto = new ProfileDto();
        BeanUtils.copyProperties(user, profileDto);
        profileDto.setRoles(AuthUtil.authorityListToCommaSeparatedString(authentication));

        return profileDto;
    }

}
