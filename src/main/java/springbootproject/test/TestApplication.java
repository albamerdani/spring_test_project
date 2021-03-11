package springbootproject.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"springboot_project.test.model", "springboot_project.test.controller", "springboot_project.test.repository", "springboot_project.test.config"})
@ComponentScan("springboot_project.test")
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "springboot_project.test.repository")
public class TestApplication {

	private static final Logger logger = LoggerFactory.getLogger(TestApplication.class);

	public static void main(String[] args) {
		logger.info("Application is started");
		SpringApplication.run(TestApplication.class, args);
	}

}
