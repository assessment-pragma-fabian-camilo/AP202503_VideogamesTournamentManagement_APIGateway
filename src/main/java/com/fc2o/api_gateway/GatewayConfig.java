package com.fc2o.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.time.Duration;

@Configuration
public class GatewayConfig {
  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
      .route(
        "orchestrator-service",
        r -> r.path("/api/v1/orchestrator/**")
          .and()
          .method(HttpMethod.PATCH, HttpMethod.DELETE, HttpMethod.POST)
          .filters(f ->
            f.retry(config ->
                config
                  .setRetries(3)
                  .setBackoff(Duration.ofMillis(2000), Duration.ofMillis(6000), 2, true)
              )
              .circuitBreaker(config ->
                config
                  .setName("orchestratorCircuitBreaker")
                  .setFallbackUri("forward:/fallback/orchestrator")
              )
          )
          .uri("lb://VideogamesTournamentManagement")
      )
      .route(
        "airtable-service",
        r -> r.path("/v0/**")
          .and()
          .method(HttpMethod.GET)
          .filters(f ->
            f.retry(config ->
                config
                  .setRetries(3)
                  .setBackoff(Duration.ofMillis(2000), Duration.ofMillis(6000), 3, true)
              )
              .circuitBreaker(config ->
                config
                  .setName("airtableCircuitBreaker")
                  .setFallbackUri("forward:/fallback/airtable")
              )
          )
          .uri("https://api.airtable.com")
      )
      .build();
  }
}
