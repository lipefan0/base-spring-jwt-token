package com.lipefan.springsecurityauth.response;

import lombok.Builder;

@Builder
public record LoginResponse(String token) {
}
