package com.angular.application;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	ApplicationRunner init(AccountRepository repository) {
		return args -> {
			Stream.of("Buzz", "Woody", "Andy", "Sid", "Potato Head",
					"Rex", "Hamm", "Slinky Dog", "Yugi Moto").forEach(name -> {
				Account account = new Account();
				account.setName(name);
				repository.save(account);
			});
			repository.findAll().forEach(System.out::println);
		};
	}

}