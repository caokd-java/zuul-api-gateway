package com.example.api.config;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableZuulProxy
public class ZuulProxyConfig {

  @Bean
  public PreFilter preFilter() {
    return new PreFilter();
  }
  @Bean
  public PostFilter postFilter() {
    return new PostFilter();
  }
  @Bean
  public ErrorFilter errorFilter() {
    return new ErrorFilter();
  }
  @Bean
  public RouteFilter routeFilter() {
    return new RouteFilter();
  }

  @Bean
  public CorsFilter corsFilter() {
    
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("OPTIONS");
    config.addAllowedMethod("HEAD");
    config.addAllowedMethod("GET");
    config.addAllowedMethod("PUT");
    config.addAllowedMethod("POST");
    config.addAllowedMethod("DELETE");
    config.addAllowedMethod("PATCH");
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
