package com.codewithseth.khmerjava_api.service;

import java.util.List;

import com.codewithseth.khmerjava_api.dto.UserDto;
import com.codewithseth.khmerjava_api.dto.UserRequestDto;

public interface IUserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Integer id);
    void createUser(UserRequestDto userRequestDto);
    void updateUser(Integer id, UserRequestDto userRequestDto);
    void deleteUser(Integer id);
}
