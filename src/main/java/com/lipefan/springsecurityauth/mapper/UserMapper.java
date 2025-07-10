package com.lipefan.springsecurityauth.mapper;

import com.lipefan.springsecurityauth.entity.User;
import com.lipefan.springsecurityauth.request.UserRequest;
import com.lipefan.springsecurityauth.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request) {
        return User
                .builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
