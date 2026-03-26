package dev.boog.money_tracker_api_gateway.routes;

import dev.boog.money_tracker_api_gateway.filters.DataServiceTokenFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

    private final DataServiceTokenFilter dataServiceTokenFilter;

    public RoutesConfiguration(DataServiceTokenFilter dataServiceTokenFilter) {
        this.dataServiceTokenFilter = dataServiceTokenFilter;
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("data-service", r -> r
                        .path("/data/**")
                        .filters(f -> f
                                .filter(dataServiceTokenFilter.apply(new DataServiceTokenFilter.Config()))
                                .rewritePath("/data/(?<path>.*)", "/api/data/${path}"))
                        .uri("http://localhost:8081"))
                .build();
    }
}
