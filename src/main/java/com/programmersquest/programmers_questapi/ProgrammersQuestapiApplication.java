package com.programmersquest.programmers_questapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.programmersquest")
@EnableJpaRepositories(basePackages = "com.programmersquest.repository")
@EntityScan(basePackages = "com.programmersquest.model")
public class ProgrammersQuestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammersQuestapiApplication.class, args);
	}

}
