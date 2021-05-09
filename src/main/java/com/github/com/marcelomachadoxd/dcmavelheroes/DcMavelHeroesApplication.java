package com.github.com.marcelomachadoxd.dcmavelheroes;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class DcMavelHeroesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DcMavelHeroesApplication.class, args);

        System.out.println("Super Poderes ativos");
    }

}
