package dev.boog.money_tracker_api_gateway.filters;

import dev.boog.money_tracker_api_gateway.filters.utils.FilterApplier;
import dev.boog.money_tracker_api_gateway.utils.*;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.*;
import java.util.*;
import org.springframework.cloud.gateway.filter.*;
import org.springframework.cloud.gateway.filter.factory.*;
import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;

@Component
public class DefaultFilter extends AbstractGatewayFilterFactory<Config> {

    public DefaultFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return FilterApplier::validateAndExtractUserId;
    }

}
