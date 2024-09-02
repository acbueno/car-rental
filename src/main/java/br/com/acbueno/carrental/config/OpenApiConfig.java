package br.com.acbueno.carrental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenApi() {
    //@formatter:off
    return new OpenAPI().info(new Info()
        .title("Car Rental API").version("1.0")
        .contact(new Contact().name("Anderson Bueno").email("anderson.carlosb@gmail.com"))
        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    //formatter:on
  }

}
