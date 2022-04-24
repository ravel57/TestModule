package ru.ravel.TestModule;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestModuleApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(TestModuleApplication.class, args);
	}

}
