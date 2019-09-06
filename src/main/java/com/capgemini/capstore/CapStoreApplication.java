package com.capgemini.capstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapStoreApplication.class, args);
		System.out.println("Capstore works on port 4444");
	}

}
