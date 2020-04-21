package com.technofolks.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OneToManyApplication {
	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}
}
