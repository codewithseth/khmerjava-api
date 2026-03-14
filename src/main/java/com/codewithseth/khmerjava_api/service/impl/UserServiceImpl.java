package com.codewithseth.khmerjava_api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithseth.khmerjava_api.dto.UserDto;
import com.codewithseth.khmerjava_api.dto.UserRequestDto;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public UserDto createUser(UserRequestDto userRequestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public UserDto updateUser(Integer id, UserRequestDto userRequestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
    
}
