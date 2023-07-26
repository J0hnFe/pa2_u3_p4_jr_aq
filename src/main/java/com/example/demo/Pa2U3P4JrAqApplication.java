package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.modelo.CtaBancaria;
import com.example.demo.repo.modelo.Propietario;
import com.example.demo.service.ICtaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4JrAqApplication implements CommandLineRunner {

	@Autowired
	private IPropietarioService propietarioService;
	@Autowired
	private ITransferenciaService transferenciaService;
	@Autowired
	private ICtaBancariaService ctaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JrAqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BigDecimal montoCta1 = new BigDecimal(100);
		BigDecimal montoCta2 = new BigDecimal(200);



		CtaBancaria ctaOrigen = new CtaBancaria();
		ctaOrigen.setNumero("111");
//		ctaOrigen.setPropietario(this.propietarioService.buscar("001"));
		ctaOrigen.setSaldo(montoCta1);
		ctaOrigen.setTipo("A");

//		this.ctaBancariaService.agregar(ctaOrigen);

		CtaBancaria ctaDestino = new CtaBancaria();
		ctaDestino.setNumero("222");
//		ctaDestino.setPropietario(this.propietarioService.buscar("002"));
		ctaDestino.setSaldo(montoCta2);
		ctaDestino.setTipo("A");

//		this.ctaBancariaService.agregar(ctaDestino);
		
		BigDecimal montoTrasferencia = new BigDecimal(200);		
		this.transferenciaService.realizarTransf(ctaOrigen.getNumero(), ctaDestino.getNumero(), montoTrasferencia);
//		System.out.println("Reporte: ");
//		this.transferenciaService.buscarTodos().stream().forEach(System.out::println);
		

	}
}
