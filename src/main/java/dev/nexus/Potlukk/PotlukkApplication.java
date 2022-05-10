package dev.nexus.Potlukk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "dev.nexus")
@EntityScan(basePackages = "dev.nexus.entities")
@EnableJpaRepositories(basePackages = "dev.nexus.repos")
public class PotlukkApplication {

	public static void main(String[] args) {SpringApplication.run(PotlukkApplication.class, args);}

}
