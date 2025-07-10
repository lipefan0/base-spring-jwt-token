package com.lipefan.springsecurityauth.service;

import com.lipefan.springsecurityauth.entity.User;
import com.lipefan.springsecurityauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
       return userRepository.save(user);
    }

}
