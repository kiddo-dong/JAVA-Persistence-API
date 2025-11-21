package com.example.SpringBoot_JPA_Repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.JPA_Springboot.springdatajpa.repository")
public class AppConfig {
}