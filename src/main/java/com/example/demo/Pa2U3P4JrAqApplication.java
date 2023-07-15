package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.modelo.Habitacion;
import com.example.demo.repo.modelo.Hotel;
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
		
		Hotel hotelNuevo = new Hotel();
		hotelNuevo.setNombre("Hotel Marriot");
		hotelNuevo.setDireccion("Amaguania");
		
		
		Habitacion h1 = new Habitacion();
		h1.setNumero("N123");
		h1.setValor(new BigDecimal(13));
		h1.setHotel(hotelNuevo);
		
		List<Habitacion> listaAux = new ArrayList<>();
		listaAux.add(h1);
		hotelNuevo.setHabitaciones(listaAux);
//		this.hotelService.agregar(hotelNuevo);
		
		System.out.println("");
		System.out.println("Inner Join");
		List<Hotel> listaHotel = this.hotelService.buscarHotelInnerJoin(); //Usa varios select
		
		for(Hotel h : listaHotel) {
			System.out.println(h.getNombre());
			System.out.println("Tiene las siguientes habitaciones: ");
			for(Habitacion ha : h.getHabitaciones()) {
				
				System.out.println(ha.getNumero());
			}
		}
		
		System.out.println("\nSQL Join Fetch");
		
		List<Hotel> listaHotel2 = this.hotelService.buscarFetchJoin();		//Usa un solo select
		
		for(Hotel h : listaHotel) {
			System.out.println(h.getNombre());
			System.out.println("Tiene las siguientes habitaciones (fetch): ");
			for(Habitacion ha : h.getHabitaciones()) {
				
				System.out.println(ha.getNumero());
			}
		}
	}
}
