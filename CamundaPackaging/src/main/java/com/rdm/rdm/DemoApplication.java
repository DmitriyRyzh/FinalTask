package com.rdm.rdm;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;


import java.io.IOException;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan({ "com.rdm.rdm*" })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			testMain(ctx);

		};
	}

	private static void testMain(ApplicationContext ctx) throws IOException {
		System.out.println("----- Старт приложения Packaging-----");

	}

}
