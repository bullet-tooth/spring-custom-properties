package com.example.springcustomproperties;

import com.example.springcustomproperties.property.MyProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringCustomPropertiesApplication implements ApplicationRunner {

  @Autowired
  private MyProperty property;

  public static void main(String[] args) {
    SpringApplication.run(SpringCustomPropertiesApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) {
    log.info("Property value: {}", property);
  }

}
