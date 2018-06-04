package com.example.springcustomproperties.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "my-property")
@PropertySource("classpath:config/custom.yml")
public class MyProperty {

  private String value;
}
