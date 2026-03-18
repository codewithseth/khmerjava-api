package com.codewithseth.khmerjava_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDto extends UserDto {
    private boolean isEmailUpdated;
}
