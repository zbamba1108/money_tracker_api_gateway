package dev.boog.money_tracker_api_gateway.authservice.dto.response;

public record LoginResponse(String accessToken, String refreshToken) {
}
