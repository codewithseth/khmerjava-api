package com.codewithseth.khmerjava_api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithseth.khmerjava_api.dto.UserDto;
import com.codewithseth.khmerjava_api.dto.UserRequestDto;
import com.codewithseth.khmerjava_api.entity.User;
import com.codewithseth.khmerjava_api.exception.ResourceNotFoundException;
import com.codewithseth.khmerjava_api.repository.UserRepository;
import com.codewithseth.khmerjava_api.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    
    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        var users = userRepository.findAll();
        var usersDto = new ArrayList<UserDto>();

        for (var user : users) {
            var userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setFirstname(user.getFirstname());
            userDto.setLastname(user.getLastname());
            userDto.setEmail(user.getEmail());
            userDto.setRoles(user.getRoles());
            userDto.setBio(user.getBio());
            userDto.setProfilePicture(user.getProfilePicture());

            usersDto.add(userDto);
        }

        return usersDto;
    }

    @Override
    public UserDto getUserById(Integer id) {
        var user = userRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id.toString())
        );
        
        var userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        userDto.setBio(user.getBio());
        userDto.setProfilePicture(user.getProfilePicture());

        return userDto;
    }

    @Override
    public void createUser(UserRequestDto userRequestDto) {
        var user = new User();
        user.setFirstname(userRequestDto.getFirstname());
        user.setLastname(userRequestDto.getLastname());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setRoles(userRequestDto.getRoles());
        user.setBio(userRequestDto.getBio());
        user.setProfilePicture(userRequestDto.getProfilePicture());

        userRepository.save(user);
    }

    @Override
    public void updateUser(Integer id, UserRequestDto userRequestDto) {
        var user = userRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id.toString())
        );

        user.setFirstname(userRequestDto.getFirstname());
        user.setLastname(userRequestDto.getLastname());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setRoles(userRequestDto.getRoles());
        user.setBio(userRequestDto.getBio());
        user.setProfilePicture(userRequestDto.getProfilePicture());

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        var user = userRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id.toString())
        );

        userRepository.delete(user);
    }

}
