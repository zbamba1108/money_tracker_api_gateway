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

    private final static String USERS_PATH = Constants.Services.AUTH_SERVICE_BASE_PATH + "/users";
    private final static String LOGOUT_PATH = Constants.Services.AUTH_SERVICE_BASE_PATH + "/auth/logout";

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            HttpMethod httpMethod = exchange.getRequest().getMethod();
            String path =  exchange.getRequest().getURI().getPath();

            boolean needsValidationAndUserIdMapping =
                    (HttpMethod.DELETE.equals(httpMethod) && path.equals(USERS_PATH))
                    || (HttpMethod.POST.equals(httpMethod) && path.equals(LOGOUT_PATH));

            return needsValidationAndUserIdMapping ?
                    FilterApplier.validateAndExtractUserId(exchange, chain)
                    : chain.filter(exchange);
        });
    }

}
