package com.example.springcustomproperties;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

/**
 * Loads yaml properties and adds them to {@link org.springframework.core.env.Environment}
 */
public class YamlLoaderEnvironmentPostProcessor implements EnvironmentPostProcessor {

  private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
  private final ResourceLoader resourceLoader = new DefaultResourceLoader();

  @Override
  public void postProcessEnvironment(ConfigurableEnvironment environment,
      SpringApplication application) {

    loadResources().stream()
        .map(this::loadYaml)
        .forEach(environment.getPropertySources()::addLast);
  }

  private PropertySource<?> loadYaml(Resource path) {
    if (!path.exists()) {
      throw new IllegalArgumentException("Resource " + path + " does not exist");
    }
    try {
      return this.loader.load(path.getFilename(), path).get(0);
    } catch (IOException ex) {
      throw new IllegalStateException(
          "Failed to load yaml configuration from " + path, ex);
    }
  }

  private List<Resource> loadResources() {
    try {
      return Arrays.asList(ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
          .getResources("classpath*:config/*.yml"));
    } catch (IOException e) {
      throw new IllegalStateException(
          "Failed to read yaml configuration file", e);
    }
  }

}
