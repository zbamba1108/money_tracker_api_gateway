package dev.boog.money_tracker_api_gateway.authservice.controllers;

import dev.boog.money_tracker_api_gateway.authservice.dto.request.LoginRequest;
import dev.boog.money_tracker_api_gateway.authservice.dto.request.UserRequest;
import dev.boog.money_tracker_api_gateway.authservice.dto.response.LoginResponse;
import dev.boog.money_tracker_api_gateway.authservice.dto.response.RefreshResponse;
import dev.boog.money_tracker_api_gateway.utils.Constants;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Profile({Constants.Profile.DOCS})
@Tag(name = Constants.Tags.AUTH_SERVICE)
@RestController
@RequestMapping(Constants.Services.AUTH_SERVICE_BASE_PATH)
public class AuthController {

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<Void> logout(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<RefreshResponse> refresh(@CookieValue(name = Constants.Tokens.REFRESH_TOKEN) String token) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequest request) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> deleteUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                           @Valid @RequestBody UserRequest request) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }
}
