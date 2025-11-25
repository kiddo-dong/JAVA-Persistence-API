package com.example.JpaRepository_Board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpaRepositoryBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRepositoryBoardApplication.class, args);
	}

}