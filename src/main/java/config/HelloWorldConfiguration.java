package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chensongyu
 */
@Configuration
public class HelloWorldConfiguration {
  @Bean
  public String helloWorld() {
    return "Hello World";
  }
}
