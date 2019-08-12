package com.zhaoshijie.services;

import com.zhaoshijie.domain.dtos.UserDto;
import com.zhaoshijie.exceptions.UserRegistrationException;

/**
 * Demo interface
 *
 * @author Zhao Shijie
 * @date 2019/08/12
 */
public interface UserService {
    void doRegister(UserDto userDto) throws UserRegistrationException;
}
