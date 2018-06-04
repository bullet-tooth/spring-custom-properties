package com.example.springcustomproperties.property;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyProperty.class)
@EnableConfigurationProperties
public class MyPropertyTest {

  @Autowired
  private MyProperty property;

  @Test
  public void test() {
    assertEquals("test", property.getValue());
  }

}
