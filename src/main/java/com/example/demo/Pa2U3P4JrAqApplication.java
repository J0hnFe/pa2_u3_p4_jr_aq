package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.funcional.MetodosReferenciados;
import com.example.demo.repo.modelo.CtaBancaria;
import com.example.demo.service.ICtaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4JrAqApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4JrAqApplication.class);

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

		LOG.info("Hilo: " + Thread.currentThread().getName()); // Indicar el hilo con el que se ejecuta el prog

		BigDecimal montoCta1 = new BigDecimal(100);

		CtaBancaria cta1 = new CtaBancaria();
		cta1.setNumero("111");
		cta1.setSaldo(montoCta1);
		cta1.setTipo("A");
		this.ctaBancariaService.agregar(cta1);

//		// Inicio
//		long tiempoInicial = System.currentTimeMillis();
//
//		for (int i = 0; i <= 30; i++) {
//
//			CtaBancaria ctaFor = new CtaBancaria();
//			ctaFor.setNumero(String.valueOf(i));
//			ctaFor.setSaldo(montoCta1);
//			ctaFor.setTipo("A");
//			this.ctaBancariaService.agregar(ctaFor);
//
//		}
//		// Final
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
//		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
//		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);

//		// Inicio
//		long tiempoInicial = System.currentTimeMillis();
//		List<CtaBancaria> lista = new ArrayList<>();
//
//		for (int i = 1;  i < 100;  i++) {
//
//			CtaBancaria ctaFor = new CtaBancaria();
//			ctaFor.setNumero(String.valueOf(i));
//			ctaFor.setSaldo(montoCta1);
//			ctaFor.setTipo("A");
//			lista.add(ctaFor);
//
//		}
//		
////		lista.stream().forEach(x -> this.ctaBancariaService.agregar(x)); //Un hilo (lento)
//		lista.parallelStream().forEach(x -> this.ctaBancariaService.agregar2(x));		//Varios hilos (rapido) hilos se llaman diferente
//		
//		// Final
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
//		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
//		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
		/*
		// Inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CtaBancaria> lista = new ArrayList<>();

		for (int i = 1;  i < 100;  i++) {

			CtaBancaria ctaFor = new CtaBancaria();
			ctaFor.setNumero(String.valueOf(i));
			ctaFor.setSaldo(montoCta1);
			ctaFor.setTipo("A");
			lista.add(ctaFor);

		}
		
//		lista.stream().forEach(x -> this.ctaBancariaService.agregar(x)); //Un hilo (lento)
		lista.parallelStream().forEach(x -> this.ctaBancariaService.agregar(x));		//Varios hilos (rapido) hilos se llaman diferente
		
		// Final
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
		*/
		

		// Inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CtaBancaria> lista = new ArrayList<>();

		for (int i = 1;  i < 100;  i++) {

			CtaBancaria ctaFor = new CtaBancaria();
			ctaFor.setNumero(String.valueOf(i));
			ctaFor.setSaldo(montoCta1);
			ctaFor.setTipo("A");
			lista.add(ctaFor);

		}
		
//		lista.stream().forEach(x -> this.ctaBancariaService.agregar(x)); //Un hilo (lento)
		Stream<String> listaFinal = lista.parallelStream().map(x -> this.ctaBancariaService.agregar2(x));
		 LOG.info("C guaradaron las siguientes cuentas: ");
		listaFinal.forEach(x -> LOG.info(x));
		
		// Final
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
	}
}
