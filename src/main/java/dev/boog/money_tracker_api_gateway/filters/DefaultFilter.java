package dev.boog.money_tracker_api_gateway.filters;

import dev.boog.money_tracker_api_gateway.utils.*;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.*;
import java.util.*;
import org.springframework.cloud.gateway.filter.*;
import org.springframework.cloud.gateway.filter.factory.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;

@Component
public class DefaultFilter extends AbstractGatewayFilterFactory<Config> {

    public DefaultFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if (authHeader == null || !authHeader.startsWith(Constants.Token.BEARER)) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            authHeader = authHeader.substring(Constants.Token.BEARER.length());

            try {
                Claims claims = Jwts.parser()
                        .verifyWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(Constants.SECRET)))
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
        });
    }

}
