package io.github.brunoonofre64.mscards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = "io.github.brunoonofre64.mscards.infra.repository")
public class MscardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscardsApplication.class, args);
	}

}
