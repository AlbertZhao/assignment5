package com.zhaoshijie.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String nickName;
    private String captcha;
}

