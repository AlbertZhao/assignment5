package com.zhaoshijie.services.impl;

import com.zhaoshijie.domain.dtos.UserDto;
import com.zhaoshijie.domain.po.User;
import com.zhaoshijie.enums.ServiceErrorCodes;
import com.zhaoshijie.exceptions.UserRegistrationException;
import com.zhaoshijie.repositories.UserRepository;
import com.zhaoshijie.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author 1547418
 * @date 2019/08/12
 */
@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void doRegister(UserDto userDto) throws UserRegistrationException {
        if (userDto ==null) {
            throw new UserRegistrationException(ServiceErrorCodes.REGISTRATION_INFO_NULL);
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userRepository.save(user);
    }
}
