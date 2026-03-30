package dev.boog.money_tracker_api_gateway.filters;

import dev.boog.money_tracker_api_gateway.filters.utils.FilterApplier;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

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
