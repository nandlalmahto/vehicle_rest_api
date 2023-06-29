package com.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehicleRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleRestApiApplication.class, args);
		System.out.println("Hello Vehicle Rest API");
	}

}
