package com.codewithseth.khmerjava_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithseth.khmerjava_api.dto.UserDto;
import com.codewithseth.khmerjava_api.service.IUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService iUserService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        List<UserDto> usersDto = iUserService.getAllUsers();
        return ResponseEntity.ok(usersDto);
    }

}
