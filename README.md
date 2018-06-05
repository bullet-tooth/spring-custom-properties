# Spring custom YAML properties example

This repository shows how to configure your 
Spring Boot application for work with custom yaml property files.

_Linked issue on [stackowerflow](https://stackoverflow.com/questions/50684737/spring-boot-custom-properties-configuration-and-tests)
which describes the problem._

So, to be able to load properties from yaml files you need:
* To implement `EnvironmentPostProcessor`
* To register it in `spring.factories`

## How does it work
`YamlLoaderEnvironmentPostProcessor` reads all `.yml` files located under `src/main/resource/config`
and adds them as `PropertySource`'s to the `Environment`. It allows to have values binding in
`@ConfigurationProperties` beans. 

## Stack:
* Spring Boot 2.0.2
* Lombok
