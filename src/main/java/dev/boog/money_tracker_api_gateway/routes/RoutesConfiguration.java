package dev.boog.money_tracker_api_gateway.routes;

import dev.boog.money_tracker_api_gateway.filters.AuthFilter;
import dev.boog.money_tracker_api_gateway.filters.Config;
import dev.boog.money_tracker_api_gateway.filters.DefaultFilter;
import dev.boog.money_tracker_api_gateway.utils.Constants;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

    private final DefaultFilter defaultFilter;

    private final AuthFilter authFilter;

    public RoutesConfiguration(DefaultFilter defaultFilter, AuthFilter authFilter) {
        this.defaultFilter = defaultFilter;
        this.authFilter = authFilter;
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(Constants.Services.DATA_SERVICE, r -> r
                        .path(Constants.Services.DATA_SERVICE_BASE_PATH + "/**")
                        .filters(f -> f
                                .filter(defaultFilter.apply(new Config()))
                                .rewritePath(Constants.Services.DATA_SERVICE_BASE_PATH + "/(?<path>.*)",
                                        Constants.Services.DATA_SERVICE_REDIRECT_BASE_PATH + "${path}")
                                .addRequestHeader(Constants.Headers.API_KEY, Constants.Secrets.INTERNAL))
                        .uri(Constants.Hosts.DATA_SERVICE_HOST))
                .route(Constants.Services.AUTH_SERVICE, r -> r
                        .path(Constants.Services.AUTH_SERVICE_BASE_PATH + "/**")
                        .filters(f -> f
                                .filter(authFilter.apply(new Config()))
                                .rewritePath(Constants.Services.AUTH_SERVICE_BASE_PATH + "/(?<path>.*)",
                                        Constants.Services.AUTH_SERVICE_REDIRECT_BASE_PATH + "${path}")
                                .addRequestHeader(Constants.Headers.API_KEY, Constants.Secrets.INTERNAL))
                        .uri(Constants.Hosts.AUTH_SERVICE_HOST))
                .build();
    }
}
