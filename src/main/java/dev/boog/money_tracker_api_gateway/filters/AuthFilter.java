package dev.boog.money_tracker_api_gateway.filters;

import dev.boog.money_tracker_api_gateway.filters.utils.FilterApplier;
import dev.boog.money_tracker_api_gateway.utils.Constants;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<Config> {

    public AuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            HttpMethod httpMethod = exchange.getRequest().getMethod();
            String path =  exchange.getRequest().getURI().getPath();

            if (HttpMethod.DELETE.name().matches(httpMethod.name()) && path.equals(Constants.Services.AUTH_SERVICE_BASE_PATH + "/users")) {
                return FilterApplier.validateAndExtractUserId(exchange, chain);
            } else if (HttpMethod.POST.name().equals(httpMethod.name()) && path.equals(Constants.Services.AUTH_SERVICE_BASE_PATH + "/auth/logout")) {
                return FilterApplier.validateAndExtractUserId(exchange, chain);
            }

            return chain.filter(exchange);
        });
    }

}
