package com.jfb.hruser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HruserApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HruserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println("BCrypt: " + encoder.encode("123456"));

	}

}
