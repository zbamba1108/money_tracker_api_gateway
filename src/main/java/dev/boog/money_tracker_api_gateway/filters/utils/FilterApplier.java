package dev.boog.money_tracker_api_gateway.filters.utils;

import dev.boog.money_tracker_api_gateway.filters.Config;
import dev.boog.money_tracker_api_gateway.filters.DefaultFilter;
import dev.boog.money_tracker_api_gateway.utils.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Base64;

public final class FilterApplier {

    private FilterApplier() {
        throw new RuntimeException(Constants.Messages.UTILITY_CLASS);
    }

    public static Mono<Void> validateAndExtractUserId(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith(Constants.Tokens.BEARER)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        authHeader = authHeader.substring(Constants.Tokens.BEARER.length());

        try {
            Claims claims = Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(Constants.Secrets.CLIENT)))
                    .build()
                    .parseSignedClaims(authHeader)
                    .getPayload();

            String userId = claims.getSubject();

            ServerWebExchange mutatedExchange = exchange.mutate()
                    .request(r -> r.header(Constants.Headers.USER_ID, userId))
                    .build();

            return chain.filter(mutatedExchange);

        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }
}
