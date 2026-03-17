package com.codewithseth.khmerjava_api.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithseth.khmerjava_api.dto.ProfileDto;
import com.codewithseth.khmerjava_api.entity.User;
import com.codewithseth.khmerjava_api.repository.UserRepository;
import com.codewithseth.khmerjava_api.service.IProfileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements IProfileService {
    
    private final UserRepository userRepository;
    
    @Override
    public ProfileDto getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(
            () -> new UsernameNotFoundException("User not found")
        );

        ProfileDto profileDto = new ProfileDto();
        BeanUtils.copyProperties(user, profileDto);
        profileDto.setRoles(authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")));

        return profileDto;
    }

}
