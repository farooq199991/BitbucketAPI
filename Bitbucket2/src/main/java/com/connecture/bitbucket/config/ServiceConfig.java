package com.connecture.bitbucket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ServiceConfig extends WebMvcConfigurerAdapter
{

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.config.annotation.
   * WebMvcConfigurerAdapter#
   * configureContentNegotiation(org.springframework.web.servlet.config.
   * annotation. ContentNegotiationConfigurer)
   */
  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
  {
    configurer.favorPathExtension(false).favorParameter(true).defaultContentType(MediaType.APPLICATION_JSON_UTF8);
  }

  /**
   * To provide swagger documentation for the REST API.
   * 
   * @return Docket object.
   */
  @Bean
  public Docket api()
  {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any()).build();
  }

  /**
   * To avoid CORS issues in UI.
   * 
   * @return Filter to check only allowed headers and methods.
   */
  @Bean
  public CorsFilter corsFilter()
  {
    CorsConfiguration config = new CorsConfiguration();
    // you USUALLY want this - need to be analyzed.
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
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
