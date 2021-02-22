package springboot_project.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class TestApplication {

	private static final Logger logger = LoggerFactory.getLogger(TestApplication.class);

	public static void main(String[] args) {
		logger.info("Application is started");
		SpringApplication.run(TestApplication.class, args);
	}

}
