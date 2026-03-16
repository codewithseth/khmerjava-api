package com.codewithseth.khmerjava_api.dto;

public record LoginDto(
    String message,
    UserDto user,
    String jwtToken
) {}
