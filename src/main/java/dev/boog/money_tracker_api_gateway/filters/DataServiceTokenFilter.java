package dev.boog.money_tracker_api_gateway.filters;

import dev.boog.money_tracker_api_gateway.utils.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Base64;

@Component
public class DataServiceTokenFilter extends AbstractGatewayFilterFactory<DataServiceTokenFilter.Config> {

    public final String secret = "secretlongenoughtobearealsecretwithadditionalcharactershopingnowislongenough"; // TODO replace with ENV_VARIABLE

    public DataServiceTokenFilter() {
        super(DataServiceTokenFilter.Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            authHeader = authHeader.replace("Bearer ", "");

            try {
                Claims claims = Jwts.parser()
                        .verifyWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret)))
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

    public static class Config {
        // can put configurable options here
    }
}
