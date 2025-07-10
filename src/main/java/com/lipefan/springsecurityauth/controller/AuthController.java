package com.lipefan.springsecurityauth.controller;

import com.lipefan.springsecurityauth.entity.User;
import com.lipefan.springsecurityauth.mapper.UserMapper;
import com.lipefan.springsecurityauth.request.UserRequest;
import com.lipefan.springsecurityauth.response.UserResponse;
import com.lipefan.springsecurityauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest user) {
        User savedUser = userService.save(UserMapper.toUser(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

}
