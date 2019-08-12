package com.zhaoshijie.controller;

import com.zhaoshijie.domain.vo.LoginVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("security")
public class SecurityController {


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<LoginVO> loginCheck(HttpServletRequest request, @RequestBody LoginVO loginVO) {

        return new ResponseEntity<>(loginVO,HttpStatus.OK);
    }


}
