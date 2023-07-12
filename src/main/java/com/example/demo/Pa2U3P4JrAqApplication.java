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
		System.out.println("");
		System.out.println("Inner Join");
		this.hotelService.buscarHotelInnerJoin().stream().forEach(System.out::println);
		System.out.println("");
		System.out.println("Outer Right Join");
		this.hotelService.buscarOuterRightJoin().stream().forEach(System.out::println);
		System.out.println("");
		System.out.println("Outer Left Join");
		this.hotelService.buscarOuterLeftJoin().stream().forEach(System.out::println);
		System.out.println("");
		System.out.println("Outer Habitacion Left Join");
		this.hotelService.buscarHabitacionOuterLeftJoin().stream().forEach(System.out::println);
		System.out.println("");
		System.out.println("Outer Full Join");
		this.hotelService.buscarOuterFullJoin().stream().forEach(System.out::println);
		
		System.out.println("");
		System.out.println("Where Inner Join");
		this.hotelService.buscarWhereJoin().stream().forEach(System.out::println);

	}

}
