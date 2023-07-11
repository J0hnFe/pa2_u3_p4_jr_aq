package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4JrAqApplication implements CommandLineRunner{

	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JrAqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.hotelService.buscarHotelInnerJoin().stream().forEach(System.out::println);
	}

}
