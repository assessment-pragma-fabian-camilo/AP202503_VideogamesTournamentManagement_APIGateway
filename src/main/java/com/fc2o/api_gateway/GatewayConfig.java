package com.fc2o.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class GatewayConfig {
  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
      .route(
        "orchestrator-service",
        r -> r.path("/api/v1/orchestrator/**").uri("lb://VideogamesTournamentManagement")
      )
      .route(
        "airtable-service",
        r -> r.path("/v0/**").and().method(HttpMethod.GET).uri("https://api.airtable.com")
      )
      .build();
  }
}
