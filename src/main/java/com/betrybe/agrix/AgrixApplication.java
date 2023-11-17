package com.betrybe.agrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

/**
 * Application main class.
 */
@SpringBootApplication
@EntityScan("com.betrybe.agrix.models.entities")
@EnableJpaRepositories("com.betrybe.agrix.models.repositories")
@Component("com.betrybe.agrix")
public class AgrixApplication {

  public static void main(String[] args) {
    SpringApplication.run(AgrixApplication.class, args);
  }

}
