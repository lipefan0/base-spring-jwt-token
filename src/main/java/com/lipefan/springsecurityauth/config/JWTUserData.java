package com.lipefan.springsecurityauth.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String name, String email) {
}
