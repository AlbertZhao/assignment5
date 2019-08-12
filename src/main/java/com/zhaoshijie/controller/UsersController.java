package com.zhaoshijie.controller;

import com.zhaoshijie.domain.dtos.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author Zhao Shijie
 * @date 2019/08/12
 */
@RestController
@RequestMapping("users")
public class UsersController {


    public ResponseEntity<?> register(@RequestBody UserDto userDto) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
