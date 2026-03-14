package com.codewithseth.khmerjava_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class KhmerjavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhmerjavaApiApplication.class, args);
	}

}
