package org.example.quorareactiveapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;


@SpringBootApplication
@EnableReactiveMongoAuditing
public class QuoraReactiveAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuoraReactiveAppApplication.class, args);
    }

}
