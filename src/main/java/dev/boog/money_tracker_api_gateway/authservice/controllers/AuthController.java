package dev.boog.money_tracker_api_gateway.authservice.controllers;

import dev.boog.money_tracker_api_gateway.authservice.dto.request.*;
import dev.boog.money_tracker_api_gateway.authservice.dto.response.*;
import dev.boog.money_tracker_api_gateway.utils.*;
import io.swagger.v3.oas.annotations.tags.*;
import jakarta.validation.*;
import org.apache.commons.lang3.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Profile({Constants.Profile.DOCS})
@Tag(name = Constants.Tags.AUTH_SERVICE)
@RestController
@RequestMapping("/authentication")
public class AuthController {

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<Void> logout(@RequestHeader(name = Constants.Headers.ACCESS_TOKEN) String token) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<RefreshResponse> refresh(@RequestHeader(name = Constants.Headers.REFRESH_TOKEN) String token) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequest request) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @DeleteMapping("users")
    public ResponseEntity<Void> deleteUser(@RequestHeader(Constants.Headers.ACCESS_TOKEN) String token,
                                           @Valid @RequestBody UserRequest request) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }
}
