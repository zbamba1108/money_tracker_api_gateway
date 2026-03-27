package dev.boog.money_tracker_api_gateway.routes;

import dev.boog.money_tracker_api_gateway.filters.*;
import org.springframework.cloud.gateway.route.*;
import org.springframework.cloud.gateway.route.builder.*;
import org.springframework.context.annotation.*;

@Configuration
public class RoutesConfiguration {

    private final DefaultFilter defaultFilter;

    public RoutesConfiguration(DefaultFilter defaultFilter) {
        this.defaultFilter = defaultFilter;
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("data-service", r -> r
                        .path("/data/**")
                        .filters(f -> f
                                .filter(defaultFilter.apply(new Config()))
                                .rewritePath("/data/(?<path>.*)", "/api/data/${path}"))
                        .uri("http://localhost:8081"))
                .route("auth-service", r -> r
                        .path("/authentication/**")
                        .filters(f -> f
                                .rewritePath("/authentication/(?<path>.*)", "/api/${path}"))
                        .uri("http://localhost:8082"))
                .build();
    }
}
