package dev.boog.money_tracker_api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("data-service", r -> r
                        .path("/data/**")
                        .filters(f -> f.rewritePath("/data/(?<path>.*)", "/api/data/${path}"))
                        .uri("http://localhost:8081"))
                .build();
    }
}
