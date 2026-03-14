package com.codewithseth.khmerjava_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String roles;
    private String bio;
    private String profilePicture;

}
