package com.codewithseth.khmerjava_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithseth.khmerjava_api.dto.UserDto;
import com.codewithseth.khmerjava_api.dto.UserRequestDto;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Integer id) {
        UserDto userDto = iUserService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody UserRequestDto userRequestDto) {
        iUserService.createUser(userRequestDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editUser(@PathVariable Integer id, @RequestBody UserRequestDto userRequestDto) {
        iUserService.updateUser(id, userRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable Integer id) {
        iUserService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
