package vn_phuocloc.phuocloc_sample_code.configuration;

import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Cách 1
// @Configuration
// public class AppConfig implements WebMvcConfigurer{
// @Override
// public void addCorsMappings(CorsRegistry registry){
// registry.addMapping("/**")
// .allowCredentials(true)
// .allowedOrigins("http://localhost:3000")
// .allowedMethods("POST, PUT, PATCH, DELETE")
// .allowedHeaders("*");
// ;
// }
// }

// Cách 2
// @Configuration
// public class AppConfig {
// @Bean
// public FilterRegistrationBean<CorsFilter> corsFilter(){
// UrlBasedCorsConfigurationSource source = new
// UrlBasedCorsConfigurationSource();
// CorsConfiguration config = new CorsConfiguration();
// config.setAllowCredentials(true);
// config.setAllowedOrigins(List.of("http://localhost:3000"));
// config.setAllowedMethods(List.of("GET", "PUT", "PATCH", "DELETE", "POST"));
// config.setAllowedHeaders(List.of("*"));
// source.registerCorsConfiguration("/**", config);
// FilterRegistrationBean bean = new FilterRegistrationBean<>(new
// CorsFilter(source));
// bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
// return bean;
// }
// }
