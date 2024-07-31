package com.rdm.rdm;

import com.rdm.rdm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
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
		System.out.println("----- Старт приложения Order-----");

	}

}
